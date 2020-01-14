# springboot5.0源码分析

## AnnotationConfigApplicationContext注解启动原理

spring有两个核心接口： `BeanFactory`和`ApplicationContext`，其中`ApplicationContext`是`BeanFactory`的子接口。他们都可代替spring容器，spring容器是生成Bean实例的工厂，并且管理容器中的Bean。

### BeanFactory与ApplicationContext的作用和区别？

#### 作用：

1. BeanFactory负责读取bean配置文档，管理bean的加载，实例化，维护bean之间的依赖关系，负责bean的生命周期。
2. ApplicationContext除了提供上述BeanFactory所能提供的功能之外，还挺了更完整的框架支持：
   1. 国际化支持
   2. 事件传递： 通过实现ApplicationContextAware接口
3. 常用的获取ApplicationContext的方法：
   1. `FileSystemXmlApplicationContext`： 从文件系统或URL指定的XML配置文件创建，参数为配置文件名或文件名数组。
   2. `ClassPathXmlApplicationContext`： 从classpath的XML配置文件创建，可以从jar包中读取配置文件。
   3. `AnnotationConfigApplicationContext`： 是基于注解来使用的，它不需要配置文件，采用Java配置类和各种注解来配置，是比较简单的方式，也是大势所趋吧。



```java
	public AnnotationConfigApplicationContext() {
        // 基于注解方式读取IOC容器
		this.reader = new AnnotatedBeanDefinitionReader(this);
        // 基于扫包的形式读取IOC容器
		this.scanner = new ClassPathBeanDefinitionScanner(this);
	}
```





```Java
<T> void doRegisterBean(Class<T> annotatedClass, @Nullable Supplier<T> instanceSupplier, @Nullable String name,
			@Nullable Class<? extends Annotation>[] qualifiers, BeanDefinitionCustomizer... definitionCustomizers) {

    // 1. AnnotatedGenericBeanDefinition 表示为注解方式启动注入配置类
		AnnotatedGenericBeanDefinition abd = new AnnotatedGenericBeanDefinition(annotatedClass);
    // 2. 判断是否使用condition条件
		if (this.conditionEvaluator.shouldSkip(abd.getMetadata())) {
			return;
		}
	// 3. 设置回调方式
		abd.setInstanceSupplier(instanceSupplier);
    // 4. 判断config类上是否有加上@Scope作用域
		ScopeMetadata scopeMetadata = this.scopeMetadataResolver.resolveScopeMetadata(abd);
    // 5. 设置scope
		abd.setScope(scopeMetadata.getScopeName());
    // 判断是否有传递beanname，如果没有传递name的话，生成beanname，默认类名小写
		String beanName = (name != null ? name : this.beanNameGenerator.generateBeanName(abd, this.registry));
 // 获取@Lazy  @Primary @DependsOn
		AnnotationConfigUtils.processCommonDefinitionAnnotations(abd);
		if (qualifiers != null) {
			for (Class<? extends Annotation> qualifier : qualifiers) {
				if (Primary.class == qualifier) {
					abd.setPrimary(true);
				}
				else if (Lazy.class == qualifier) {
					abd.setLazyInit(true);
				}
				else {
					abd.addQualifier(new AutowireCandidateQualifier(qualifier));
				}
			}
		}
		for (BeanDefinitionCustomizer customizer : definitionCustomizers) {
			customizer.customize(abd);
		}

		BeanDefinitionHolder definitionHolder = new BeanDefinitionHolder(abd, beanName);
		definitionHolder = AnnotationConfigUtils.applyScopedProxyMode(scopeMetadata, definitionHolder, this.registry);
		BeanDefinitionReaderUtils.registerBeanDefinition(definitionHolder, this.registry);
	}
```

#### 流程图

![](/home/memo012/下载/ioc流程图.png)

## spring的生命周期

1. 实例化对象

2. setter注入，执行bean的属性依赖注入

3. BeanNameAware的setBeanName()，如果实现该接口，则执行其setBeanName方法

4. BeanFactoryAware的setBeanFactory(),如果实现该接口，则执行其setBeanFactory方法

5. BeanPostProcessor的processBeforeInitialization()，如果有关联的processor，则在bean初始化之前都会执行这个实例的processBeforeInitialization()方法

6. InitializingBean的afterPropertiesSet()，如果实现了该接口，则执行其afterPropertiesSet()方法

   Bean定义文件中定义init-method

7. BeanPostProcessors的processAfterInitialization(),如果有关联的Processor，则在bean初始化之前都会执行这个实例的processAfterInitialization()方法
8. DisposableBean的destroy()，在容器关闭时，如果bean类实现了该接口，则执行它的destroy()方法
9. Bean定义文件中定义destroy-method，在容器关闭时，可以在Bean定义文件中使用‘destroy-method’定义的方法



springBean的生命周期Bean的创建（构造函数方法）->初始化（自定义initMethod方法）->销毁过程

可以自定义方法初始化与销毁的方法



### spring创建对象的时间

单实例： 在容器启动的时候创建对象

多实例： 在每次获取的时候创建对象，容器启动之后



### 对象的初始化和销毁

1. 对象的初始化：

   对象创建完成，并赋值好，调用初始化方法...

   IOC容器初始化单例对象都是循环遍历调用getBean方法

2. 对象的销毁

   单实例： 容器关闭的时候

   多实例： 容器不会管理这个bean，容器不会调用销毁方法



### BeanPostProcessor

后置处理器作用就是可以对初始化实现增加

### 生命周期图

![](/home/memo012/下载/bean生命周期.png)



### 问题

1. 单例和多例到底在什么时候初始化的？ 

   单例默认情况下是在容器被加载的时候就会初始化；多例在每次获取Bean的对象的时候就会去初始化

2. 如何判断对象初始化?

   bean初始化  指的就是对象已经创建里面所有的set方法都已经执行完毕了！

   
一、springboot中有2种方式使用自定义配置

@Value:单个属性注入

@ConfigurationProperties类型安全加载

二、配置文件
properties和yml文件都存在，则已properties为准

不同环境提供不同的profile文件，命名规则：application-{env}.yml
使用spring.profiles.active选项指定不同的profile
注意：如果基础配置文件和某个环境配置文件同时存在一个配置项，以环境配置文件为准




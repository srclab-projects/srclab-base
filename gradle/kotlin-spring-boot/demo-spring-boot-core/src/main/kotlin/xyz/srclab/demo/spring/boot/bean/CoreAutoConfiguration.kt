package xyz.srclab.demo.spring.boot.autoconfiguration

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import xyz.srclab.demo.spring.boot.core.CoreBean
import xyz.srclab.demo.spring.boot.core.CoreBeanProperties

@Configuration
open class CoreAutoConfiguration {

    @ConditionalOnMissingBean
    @Bean
    open fun coreBean(): CoreBean {
        println("build>>>>>>>>>xyz.srclab.spring.boot.core.coreBean")
        return CoreBean()
    }

    @ConfigurationProperties(prefix = "demo.core")
    @Bean
    open fun coreBeanProperties(): CoreBeanProperties {
        return CoreBeanProperties()
    }
}
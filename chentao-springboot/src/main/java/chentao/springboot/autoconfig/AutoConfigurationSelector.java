package chentao.springboot.autoconfig;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.ArrayList;
import java.util.ServiceLoader;

/**
 * 导入自动配置类
 */
public class AutoConfigurationSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {

        ServiceLoader<AutoConfig> serviceLoader = ServiceLoader.load(AutoConfig.class);
        ArrayList<String> strings = new ArrayList<>();

        for (AutoConfig autoConfig : serviceLoader) {
            strings.add(autoConfig.getClass().getName());
        }
        return strings.toArray(new String[0]);
    }
}

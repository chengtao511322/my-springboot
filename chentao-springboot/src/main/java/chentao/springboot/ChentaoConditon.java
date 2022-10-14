package chentao.springboot;

import chentao.springboot.annotation.ChentaoConditionOnClass;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

/**
 * 该类用于判断条件是否生效,成立则表示满足条件相关的配置才会生效
 */
public class ChentaoConditon implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata metadata) {

        //1.拿到注解配置的类路径
        Map<String, Object> annotationAttributes = metadata.getAnnotationAttributes(ChentaoConditionOnClass.class.getName());

        String classPath = (String) annotationAttributes.get("value");

        //2.拿到类路径加载类,如果加载不到说明没有配置该类
        try {
            conditionContext.getClassLoader().loadClass(classPath);
        } catch (ClassNotFoundException e) {
            return false;
        }

        return true;
    }
}

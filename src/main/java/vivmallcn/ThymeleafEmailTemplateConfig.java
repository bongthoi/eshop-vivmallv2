package vivmallcn;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;

@Configuration
public class ThymeleafEmailTemplateConfig {




		@Bean
        public TemplateEngine emailTemplateEngine() {
			SpringTemplateEngine	templateEngine = new SpringTemplateEngine();
            templateEngine.addTemplateResolver(htmlTemplateResolver());

            return templateEngine;
        }

        private static ITemplateResolver htmlTemplateResolver() {
            final ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
            templateResolver.setOrder(Integer.valueOf(0));
            templateResolver.setPrefix("classpath:/templates/");
            templateResolver.setSuffix(".html");
            templateResolver.setTemplateMode(TemplateResolver.DEFAULT_TEMPLATE_MODE);
            templateResolver.setCharacterEncoding("UTF-8");
            templateResolver.setCacheable(false);
            return templateResolver;
        }
    

}

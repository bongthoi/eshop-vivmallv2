package vivmallcn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
	
	
	@Configuration
	public static class App1ConfigurationAdapter extends WebSecurityConfigurerAdapter {
		@Autowired
		private  UserDetailsService userDetailsService;
		
		@Bean
		public  PasswordEncoder passwordEncoder() {
			return new BCryptPasswordEncoder();
		}
	    public App1ConfigurationAdapter() {
	        super();
	    }
	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	    	 auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	    }
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http
	        .headers()
	        .frameOptions()
			.sameOrigin()
			.and() 
			.authorizeRequests()
			.antMatchers("/order/**","/_user/**").hasAnyRole("USER,ADMIN")
			.antMatchers("/admin/**").hasAnyRole("ADMIN,AGENTVI,AGENTCN")
	          .and()
	          .formLogin()
	          .loginPage("/user/login/form")
	          .loginProcessingUrl("/user_login")
	          .failureUrl("/user/login/form?error")
	          .defaultSuccessUrl("/home")
	           
	          .and()
	          .logout()
	          .logoutUrl("/user_logout")
	          .logoutSuccessUrl("/home")
	          .deleteCookies("JSESSIONID")
	          .and()
	          .exceptionHandling()
	          .accessDeniedPage("/403")
	          .and()
	          .csrf().disable();
	    }
	}
	/*@Configuration
	public static class App11ConfigurationAdapter extends WebSecurityConfigurerAdapter {
		@Autowired
		private  UserDetailsService userDetailsService;
		
		@Bean
		public  PasswordEncoder passwordEncoder() {
			return new BCryptPasswordEncoder();
		}
	    public App11ConfigurationAdapter() {
	        super();
	    }
	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.inMemoryAuthentication()
	          .withUser("admin@gmail.com")
	          .password("123456")
	          .roles("ADMIN");
	    	 auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	    }
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.headers()
	        .frameOptions()
			.sameOrigin()
			.and() 
			.authorizeRequests()
			.antMatchers("/admin/**").hasAnyRole("ADMIN,AGENTVI,AGENTCN")
	          .and()
	          .formLogin()
	          .loginPage("/loginAdmin")
	          .loginProcessingUrl("/admin_login")
	          .failureUrl("/loginAdmin?error")
	          .defaultSuccessUrl("/admin")
	           
	          .and()
	          .logout()
	          .logoutUrl("/admin_logout")
	          .logoutSuccessUrl("/loginAdmin")
	          .deleteCookies("JSESSIONID")
	          .and()
	          .exceptionHandling()
	          .accessDeniedPage("/403")
	          .and()
	          .csrf().disable();
	    }
	}*/
	
	/*@Configuration
	@Order(2)
	public static class App2ConfigurationAdapter extends WebSecurityConfigurerAdapter {
	 
	    public App2ConfigurationAdapter() {
	        super();
	    }
	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.inMemoryAuthentication()
	          .withUser("user@gmail.com")
	          .password("123456")
	          .roles("USER");
	    }
	    @Override
		protected void configure(HttpSecurity http) throws Exception {
	        http.authorizeRequests()
			.antMatchers("/order/**").hasAnyRole("USER")
	          .and()
	          .formLogin()
	          .loginPage("/loginUser")
	          .loginProcessingUrl("/user_login")
	          .failureUrl("/loginUser?error")
	          .defaultSuccessUrl("/user")
	           
	          .and()
	          .logout()
	          .logoutUrl("/user_logout")
	          .logoutSuccessUrl("/loginUser")
	          .deleteCookies("JSESSIONID")
	           
	          .and()
	          .exceptionHandling()
	          .accessDeniedPage("/403")
	           
	          .and()
	          .csrf().disable();
	    }
	}*/

}

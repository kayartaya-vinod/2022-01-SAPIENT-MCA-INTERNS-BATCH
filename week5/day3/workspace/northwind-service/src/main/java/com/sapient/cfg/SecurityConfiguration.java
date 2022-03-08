package com.sapient.cfg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    DataSource dataSource;


    // this method is automatically invoked because of @Autowired annotation, and all the
    // parameters of this method will be automatically wired with any matching objects found
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("vinod")
//                .password("{noop}topsecret")
//                .roles("ADMIN", "USER")
//                .and()
//                .withUser("shyam")
//                .password("{noop}secret")
//                .roles("USER");


        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(new BCryptPasswordEncoder(12))
                .usersByUsernameQuery("select email, password, is_active from USERS where email = ?")
                .authoritiesByUsernameQuery("select email, role from USER_ROLES where email = ?");
    }

    @Configuration
    public static class NorthwindWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter{
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.antMatcher("/api/**")
                    .authorizeHttpRequests()
                    .anyRequest()
                    .hasRole("ADMIN")
                    .and()
                    .httpBasic();
        }
    }
}

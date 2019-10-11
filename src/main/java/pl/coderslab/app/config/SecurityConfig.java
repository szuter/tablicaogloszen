package pl.coderslab.app.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/messageBoard");
        dataSource.setUsername("root");
        dataSource.setPassword("coderslab");
        return dataSource;
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .passwordEncoder(passwordEncoder())
                .dataSource(dataSource())
                .usersByUsernameQuery("select email,password,true from users where email =?")
                .authoritiesByUsernameQuery("select email, access from users where email =?");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin()
                .loginPage("/login")
                .usernameParameter("email")
                .passwordParameter("password")
                .defaultSuccessUrl("/home")
                .and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/registration").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/home").permitAll()
                .antMatchers("/").permitAll()
                .antMatchers("/home/advertisement/show").permitAll()
                .antMatchers("/home/comment/add").permitAll()
                .anyRequest().authenticated();
    }
}

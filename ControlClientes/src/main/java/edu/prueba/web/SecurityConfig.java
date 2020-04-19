package edu.prueba.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    //inyectamos el servicio de usuario que ya creamos en usuarioService, userdetailsservice
    @Autowired
    private UserDetailsService userDetailsService;
    //definimos el tipo de encriptacion
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
  }
    @Autowired
    public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception{
   //inyectamos la instancia de userdetailsservice
   build.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    
    } 
    
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/editar/**", "/agregar/**", "/eliminar")
                    .hasRole("ADMIN")
                .antMatchers("/")
                    .hasAnyRole("USER","ADMIN")
                .and()
                    .formLogin()
                    .loginPage("/login")
                .and()
                    .exceptionHandling().accessDeniedPage("/errores/403")
                ;
    }
}

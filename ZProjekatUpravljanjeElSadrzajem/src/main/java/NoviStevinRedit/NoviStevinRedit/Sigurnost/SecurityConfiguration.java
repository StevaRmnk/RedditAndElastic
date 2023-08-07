package NoviStevinRedit.NoviStevinRedit.Sigurnost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    public void configureAuthentication(
            AuthenticationManagerBuilder authenticationManagerBuilder)
            throws Exception {

        authenticationManagerBuilder
                .userDetailsService(this.userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public AuthenticationTokenFilter authenticationTokenFilterBean()
            throws Exception {
        AuthenticationTokenFilter authenticationTokenFilter = new AuthenticationTokenFilter();
        authenticationTokenFilter
                .setAuthenticationManager(authenticationManagerBean());
        return authenticationTokenFilter;
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        //Naglasavamo browser-u da ne cache-ira podatke koje dobije u header-ima
        //detaljnije: https://www.baeldung.com/spring-security-cache-control-headers
        httpSecurity.headers().cacheControl().disable();
        //Neophodno da ne bi proveravali autentifikaciju kod Preflight zahteva
        httpSecurity.cors();
        //sledeca linija je neophodna iskljucivo zbog nacina na koji h2 konzola komunicira sa aplikacijom
        httpSecurity.headers().frameOptions().disable();
        httpSecurity.csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/users/").permitAll()
                .antMatchers(HttpMethod.POST, "/users/").permitAll()
                .antMatchers(HttpMethod.POST,"/users/login").permitAll()
                .antMatchers(HttpMethod.PUT, "/users/update/{korisnickoIme}").permitAll()
                .antMatchers(HttpMethod.DELETE,"/users/{korisnickoIme}").permitAll()
                .antMatchers(HttpMethod.GET,"/users/{korisnickoIme}").permitAll()
                .antMatchers(HttpMethod.POST,"/communities/").permitAll()
                .antMatchers(HttpMethod.GET,"/communities/").permitAll()
                .antMatchers(HttpMethod.GET,"/communities/DTO").permitAll()
                .antMatchers(HttpMethod.GET,"/communities/{id}").permitAll()
                .antMatchers(HttpMethod.PUT,"/communities/update/{id}").permitAll()
                .antMatchers(HttpMethod.POST,"/posts/").permitAll()
                .antMatchers(HttpMethod.GET,"/posts/").permitAll()
                .antMatchers(HttpMethod.GET,"/posts/DTO").permitAll()
                .antMatchers(HttpMethod.GET,"/posts/idZajednice/{idZajednice}").permitAll()
                .antMatchers(HttpMethod.GET,"/posts/idZajednice2/{idZajednice}").permitAll()
                .antMatchers(HttpMethod.GET,"/posts/{id}").permitAll()
                .antMatchers(HttpMethod.GET,"/posts/post/{id}").permitAll()
                .antMatchers(HttpMethod.POST,"/reactions/").permitAll()
                .antMatchers(HttpMethod.GET,"/reactions/karma/{idObjave}").permitAll()
                .antMatchers(HttpMethod.DELETE,"/posts/delete/{id}").permitAll()
                .antMatchers(HttpMethod.PUT,"/posts/update/{id}").permitAll()
                .antMatchers(HttpMethod.GET,"/users/DTO/{korisnickoIme}").permitAll()
                .antMatchers(HttpMethod.GET,"/reactions/karmaKor/{korisnickoIme}").permitAll()
                .antMatchers(HttpMethod.POST,"/users/lozinka/{korisnickoIme}").permitAll()
                .antMatchers(HttpMethod.GET,"/pravila/{idZajednice}").permitAll()
                .antMatchers(HttpMethod.POST, "/pravila/").permitAll()
                .antMatchers(HttpMethod.POST,"/komentari/").permitAll()
                .antMatchers(HttpMethod.GET,"/komentari/{idObjave}").permitAll()

                .antMatchers(HttpMethod.GET,"/api/zajednice/all").permitAll()
                .antMatchers(HttpMethod.GET,"/api/zajednice/naziv/{naziv}").permitAll()
                .antMatchers(HttpMethod.GET,"/api/zajednice/opis/{opis}").permitAll()
                .antMatchers(HttpMethod.GET,"/api/zajednice/pdfOpis/{pdfOpis}").permitAll()
                .antMatchers(HttpMethod.POST,"/api/zajednice/pdf").permitAll()
                .antMatchers(HttpMethod.POST,"/api/zajednice/dodaj").permitAll()

                .antMatchers(HttpMethod.GET,"/api/objave/all").permitAll()
                .antMatchers(HttpMethod.GET,"/api/objave/naslov/{naslov}").permitAll()
                .antMatchers(HttpMethod.GET,"/api/objave/tekst/{tekst}").permitAll()
                .antMatchers(HttpMethod.GET,"/api/objave/pdfTekst/{pdfTekst}").permitAll()
                .antMatchers(HttpMethod.POST,"/api/objave/pdfObjave").permitAll()
                .antMatchers(HttpMethod.POST,"/api/objave/dodaj").permitAll()



                .anyRequest().authenticated();

        httpSecurity.addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);
    }
}
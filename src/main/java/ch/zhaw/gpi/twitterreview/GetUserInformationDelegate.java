package ch.zhaw.gpi.twitterreview;

import javax.inject.Named;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

/**
 * GetUserInformationDelegate
 */
@Named("getUserInformationAdapter")
public class GetUserInformationDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        String userName = (String) execution.getVariable("anfrageStellenderBenutzer");

        RestTemplate restTemplate = new RestTemplate();

        String fullName;
        String email;
        try {
            User user = restTemplate.getForObject("http://localhost:8070/userapi/v1/users/{userName}", User.class, userName);
            
            fullName = user.getFirstName() + " " + user.getOfficialName();
            email = user.getEmail();
        } catch (HttpClientErrorException e) {
            fullName = "Mr. X";
            email = "x@x.ch";
        }

        execution.setVariable("fullName", fullName);
        execution.setVariable("email", email);
    }

    
}
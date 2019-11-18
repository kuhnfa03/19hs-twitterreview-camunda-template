package ch.zhaw.gpi.twitterreview;

import javax.inject.Named;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * SendReminderDelegate
 */
@Named("sendReminderAdapter")
public class SendReminderDelegate implements JavaDelegate {

    @Autowired
    private MailService mailService;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        String to = (String) execution.getVariable("to");
        String subject = (String) execution.getVariable("subject");

        String body = "Bitte erledigen Sie Ihre fällige Aufgabe.";

        mailService.sendMail(to, subject, body);
    }    
}
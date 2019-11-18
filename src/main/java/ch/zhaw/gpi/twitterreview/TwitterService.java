package ch.zhaw.gpi.twitterreview;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;

/**
 * TwitterService
 */
@Component
public class TwitterService {

    private Twitter twitter;

    @PostConstruct
    private void init(){
        try {
            twitter = TwitterFactory.getSingleton();        
            System.out.println("TWITTER: Erfolgreich angemeldet");    
        } catch (Exception e) {
            System.err.println("TWITTER: Anmeldung fehlgeschlagen. Meldung: " + e.getLocalizedMessage());
        }
    }

    public void updateStatus(String statusText) throws Exception {
        try {
            Status status = twitter.updateStatus(statusText);

            System.out.println("TWITTER: Erfolgreich getweetet:" + status.getText());
        } catch (Exception e) {
            System.err.println("TWITTER: Tweet posten fehlgeschlagen: " + e.getLocalizedMessage());

            // Fehler an aufrufende Methode zurück geben
            throw new Exception("TWITTER: Tweet posten fehlgeschlagen", e);
        }
    }

}
package ch.zhaw.gpi.twitterreview;

import javax.inject.Named;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * SendTweetDelegate
 */
@Named("sendTweetAdapter")
public class SendTweetDelegate implements JavaDelegate {

    @Autowired
    private TwitterService twitterService;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        String tweet = (String) execution.getVariable("tweetContent");

        twitterService.updateStatus(tweet);

    }

    
}
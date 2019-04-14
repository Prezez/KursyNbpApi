package com.sda.javagda21.Koty;

import net.gpedro.integrations.slack.SlackApi;
import net.gpedro.integrations.slack.SlackMessage;

public class Main {

    /*
    curl -X POST -H 'Content-type: application/json' --data '{"text":"Hello, World!"}'
    https://hooks.slack.com/services/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
     */
    public static void main(String[] args) {
        SlackApi api = new SlackApi("https://hooks.slack.com/services/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");
        api.call(new SlackMessage(""));
    }


}

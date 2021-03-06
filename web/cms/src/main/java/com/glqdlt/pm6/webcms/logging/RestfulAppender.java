package com.glqdlt.pm6.webcms.logging;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Date 2019-11-08
 *
 * @author glqdlt
 */
public class RestfulAppender extends AppenderBase<ILoggingEvent> {

    private final RestTemplateBuilder builder;
    private String webhookUrl;
    private String emoji;

    public void setEmoji(String emoji) {
        this.emoji = emoji;
    }

    public String getWebhookUrl() {
        return webhookUrl;
    }

    public void setWebhookUrl(String webhookUrl) {
        this.webhookUrl = webhookUrl;
    }

    public RestfulAppender() {
        this.builder = new RestTemplateBuilder().
                setConnectTimeout(Duration.ofSeconds(30));

    }

    /**
     * emoji list.. 는 아래를 참고.
     *
     * @param eventObject
     * @see <a href='https://www.webfx.com/tools/emoji-cheat-sheet/'>https://www.webfx.com/tools/emoji-cheat-sheet/</a>
     */
    @Override
    protected void append(ILoggingEvent eventObject) {
        if (eventObject.getLevel().equals(Level.ERROR)) {
            try {
                RestTemplate z = builder.build();
                Map<String, String> map = new LinkedHashMap<>();
                map.put("text", eventObject.getMessage());
                map.put("icon_emoji", Optional.ofNullable(getEmoji()).orElse(":ghost:"));
                RequestEntity requestEntity;
                requestEntity = RequestEntity.post(new URI(getWebhookUrl()))
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(map);
                ResponseEntity<String> ee = z.exchange(requestEntity, String.class);
            } catch (RuntimeException | URISyntaxException e) {
                throw new RuntimeException(e);
            }
        }

    }

    private String getEmoji() {
        return this.emoji;
    }
}

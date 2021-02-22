package cz.upce.fei.dependencyinjector.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public final class HTMLSeparatorService {
    private final String ATTR_PATTERN = "[\\<]%s[\\w\\W]+?%s=\"([\\w\\W]+?)\"[\\w\\W]+?[\\>]";
    private final String TAG_PATTERN = "[\\<]%s[\\w\\W]+?[\\>]";

    public String download(final String url) throws IOException {
        final StringBuilder stringBuffer = new StringBuilder();
        final BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(new URL(url).openStream())
        );

        String line;
        while((line = bufferedReader.readLine()) != null)
            stringBuffer.append(line);

        bufferedReader.close();

        return stringBuffer.toString();
    }

    public List<String> separateTags(final String html, final String tag){
        final List<String> urls = new ArrayList<>();

        final Pattern pattern = Pattern.compile(String.format(TAG_PATTERN, tag));
        final Matcher matcher = pattern.matcher(html);

        while(matcher.find()){
            urls.add(matcher.group(1));
        }

        return urls;
    }

    public List<String> separateAttributes(final String html, final String tag, final String attribute){
        final List<String> urls = new ArrayList<>();

        final Pattern pattern = Pattern.compile(String.format(ATTR_PATTERN, tag, attribute));
        final Matcher matcher = pattern.matcher(html);

        while(matcher.find()){
            urls.add(matcher.group(1));
        }

        return urls;
    }
}

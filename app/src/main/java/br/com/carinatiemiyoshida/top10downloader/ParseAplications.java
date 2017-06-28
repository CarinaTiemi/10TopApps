package br.com.carinatiemiyoshida.top10downloader;

import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.StringReader;
import java.util.ArrayList;

/**
 * Created by CarinaTiemiYoshida on 09/06/2017.
 */

public class ParseAplications {
    private static final String TAG = "ParseAplications";
    private ArrayList<FeedEntry> aplications;

    public ParseAplications() {
        this.aplications = new ArrayList<>();
    }

    public ArrayList<FeedEntry> getAplications() {
        return aplications;
    }

    public boolean parse(String xmLData){
        boolean status = true;
        FeedEntry currentRecord = null;
        boolean inEntry = false;
        boolean gotImage = false;
        String textValue = "";

        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();
            xpp.setInput(new StringReader(xmLData));
            int eventType = xpp.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT){
                String tagName = xpp.getName();
                switch (eventType){
                    case XmlPullParser.START_TAG:
                        Log.d(TAG, "parse: Starting tag for " + tagName);
                        if ("entry".equalsIgnoreCase(tagName)){
                            inEntry = true;
                            currentRecord = new FeedEntry();
                        }else if ("image".equalsIgnoreCase(tagName) && inEntry){
                            String imageResolution = xpp.getAttributeValue(null,"height");
                            if (imageResolution != null){
                                gotImage = "53".equalsIgnoreCase(imageResolution);
                            }
                        }
                        break;

                    case XmlPullParser.TEXT:
                        textValue = xpp.getText();
                        break;

                    case XmlPullParser.END_TAG:
                        Log.d(TAG, "parse: Ending tag for " + tagName);
                        if (inEntry){
                            if ("entry".equalsIgnoreCase(tagName)){
                                aplications.add(currentRecord);
                                inEntry = false;
                            } else if ("name".equalsIgnoreCase(tagName)){
                                currentRecord.setName(textValue);
                            }else if("artist".equalsIgnoreCase(tagName)){
                                currentRecord.setArtist(textValue);
                            }else if("releaseDate".equalsIgnoreCase(tagName)) {
                                currentRecord.setReleaseDate(textValue);
                            }else if("summary".equalsIgnoreCase(tagName)) {
                                currentRecord.setSummary(textValue);
                            }else if("image".equalsIgnoreCase(tagName)) {
                                if (gotImage) {
                                    currentRecord.setImageURL(textValue);
                                }
                            }
                        }
                        break;

                    default:
                        break;
                }
                eventType = xpp.next();
            }
            for (FeedEntry app: aplications){
                Log.d(TAG, "***********");
                Log.d(TAG, app.toString());
            }
        }catch (Exception e){
            status = false;
            e.printStackTrace();
        }
        return status;
    }
}

package net.dean.jraw.models;

import com.google.auto.value.AutoValue;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.io.Serializable;
import java.util.List;

@AutoValue
public abstract class SubmissionPreview implements Serializable {
    public abstract List<ImageSet> getImages();
    public abstract boolean isEnabled();

    public static SubmissionPreview create(List<ImageSet> newImages, boolean newEnabled) {
        return new AutoValue_SubmissionPreview(newImages, newEnabled);
    }

    public static JsonAdapter<SubmissionPreview> jsonAdapter(Moshi moshi) {
        return new AutoValue_SubmissionPreview.MoshiJsonAdapter(moshi);
    }

    @AutoValue
    public static abstract class ImageSet implements Serializable {
        public abstract Variation getSource();
        public abstract List<Variation> getResolutions();
        public abstract String getId();

        public static ImageSet create(Variation newSource, List<Variation> newResolutions, String newId) {
            return new AutoValue_SubmissionPreview_ImageSet(newSource, newResolutions, newId);
        }

        public static JsonAdapter<ImageSet> jsonAdapter(Moshi moshi) {
            return new AutoValue_SubmissionPreview_ImageSet.MoshiJsonAdapter(moshi);
        }
    }

    @AutoValue
    public static abstract class Variation implements Serializable {
        public abstract String getUrl();
        public abstract int getWidth();
        public abstract int getHeight();

        public static Variation create(String newUrl, int newWidth, int newHeight) {
            return new AutoValue_SubmissionPreview_Variation(newUrl, newWidth, newHeight);
        }

        public static JsonAdapter<Variation> jsonAdapter(Moshi moshi) {
            return new AutoValue_SubmissionPreview_Variation.MoshiJsonAdapter(moshi);
        }
    }

    /** New Addition **/
    @Nullable @Json(name = "reddit_video_preview") public abstract EmbeddedMedia.RedditVideo getRedditVideo();

}

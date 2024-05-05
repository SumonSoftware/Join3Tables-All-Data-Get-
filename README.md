<h3> Join 3 Tables All Data Get</h3>


## Step 1: In `AndroidManifest.xml` <br>

`Add below Permissions.`
```xml
   <!-- Storage Permission -->
    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
    <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
    <!-- Need this for Android 13 or higher -->
    <uses-permission android:name="android.permission.READ_MEDIA_IMAGES" />
    <uses-permission android:name="android.permission.READ_MEDIA_VIDEO" />
    <uses-permission android:name="android.permission.READ_MEDIA_AUDIO" />
```
Also add the following attribute to the `<application>` tag inside `AndroidManifest.xml`.
```xml





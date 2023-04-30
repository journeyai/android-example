# Journey ID SDK Integration

## Download

The Journey ID Android SDK is available on `maven { url 'https://s01.oss.sonatype.org/content/repositories/snapshots/'}`. It's required that you add this repository to your project on the `settings.gradle` file.

```kotlin
implementation "com.journeyid:sdk:1.0.0-SNAPSHOT"
```
## Quick Start

#### Initializing

To integrate the drawer to an existing `Activity`, instantiate an object of the `Journey` class in the `onStart()` method, using the `Activity` reference as the constructor parameter:

```kotlin
override fun onStart() {
    super.onStart()
    Journey(this)
}
```

## Requirements

#### Databinding
The sdk requires the `databinding` feature to be enabled. If not yet present on your project, add the following block to the `android` body of the module `build.gradle` file:

```kotlin
dataBinding {
    enabled = true
}
```

#### App Links support

For the application to trigger the drawer when the user clicks on a pipeline link, the app id and fingerprint must be declared to the .wellknown file of the host and the following `intent filters` must be added to the `Activity` declaration on the `AndroidManifest.xml` file:

```xml
<intent-filter android:autoVerify="true">
    <action android:name="android.intent.action.VIEW" />

    <category android:name="android.intent.category.DEFAULT" />
    <category android:name="android.intent.category.BROWSABLE" />

    <data android:scheme="https" />
    <data android:scheme="http" />

    <!-- Use the correct host that should trigger the app links feature -->
    <data android:host="host" />
</intent-filter>
```

Check out Android's App Links [full documentation here](https://developer.android.com/training/app-links).

# Push Notification integration
## Integrate Firebase Cloud Messaging
The JourneyID Android SDK utilizes FCM as the push notification platform. If not yet integrated to your app, please follow the guide below:
#### [Firebase Cloud Messaging official setup guide](https://firebase.google.com/docs/cloud-messaging/android/client)


## Inform the application id and fingerprints

Copy the **applicationId** from the app level build.gradle file. It will be in a format similar to **com.journeyid.app**.

You can get the SHA-1 of your signing certificate using the Gradle signingReport command:
```sh
./gradlew signingReport
```
The report will include the information for each of your app's variants:
```kotlin
> Task :app:signingReport
Variant: debug
Config: debug
Store: ~/.android/debug.keystore
Alias: AndroidDebugKey
MD5: A5:88:41:04:8D:06:71:6D:FE:33:76:87:AC:AD:19:23
SHA1: A7:89:E5:05:C8:17:A1:22:EA:90:6E:A6:EA:A3:D4:8B:3A:30:AB:18
SHA-256: 05:A2:2C:35:EE:F2:51:23:72:4D:72:67:A5:6C:8C:58:22:2A:00:D6:DB:F6:45:D5:C1:82:D2:80:A4:69:A8:FE
Valid until: Wednesday, August 10, 2044
```

Collect the data and provide to your support engineer. It will allow the configuration file to be generated and shared.


## Add the configuration file to your project
JourneyID will generate and share the information that must be placed in the local.properties file.  This is required for Firebase to initialize the push notification service.

## Register the device
For the push notifications to work, a device registration JourneyID stage must be completed successfully.

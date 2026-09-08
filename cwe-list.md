CWE-89
Example 1
Source:
[ContentApi.java:55](E:/DefensePoint/benchmarks/android-java1/gpslogger/gpslogger/src/main/java/com/mendhak/gpslogger/common/ContentApi.java#L55)

step 1:
[ContentApi.java:56](E:/DefensePoint/benchmarks/android-java1/gpslogger/gpslogger/src/main/java/com/mendhak/gpslogger/common/ContentApi.java#L56)

step 2:
[TrackSummaryStore.java:128](E:/DefensePoint/benchmarks/android-java1/gpslogger/gpslogger/src/main/java/com/mendhak/gpslogger/common/TrackSummaryStore.java#L128)

step 3:
[TrackSummaryStore.java:165](E:/DefensePoint/benchmarks/android-java1/gpslogger/gpslogger/src/main/java/com/mendhak/gpslogger/common/TrackSummaryStore.java#L165)

Sink:
[TrackSummaryStore.java:174](E:/DefensePoint/benchmarks/android-java1/gpslogger/gpslogger/src/main/java/com/mendhak/gpslogger/common/TrackSummaryStore.java#L174)

Note: engineered host: module has no SQLite DB; added TrackSummaryStore SQLiteOpenHelper (track-index cache) queried through the existing exported ContentApi provider

CWE-338
Example 1
Source:
[PreferenceHelper.java:1515](E:/DefensePoint/benchmarks/android-java1/gpslogger/gpslogger/src/main/java/com/mendhak/gpslogger/common/PreferenceHelper.java#L1515)

step 1:
[PreferenceHelper.java:167](E:/DefensePoint/benchmarks/android-java1/gpslogger/gpslogger/src/main/java/com/mendhak/gpslogger/common/PreferenceHelper.java#L167)

step 2:
[PreferenceHelper.java:1516](E:/DefensePoint/benchmarks/android-java1/gpslogger/gpslogger/src/main/java/com/mendhak/gpslogger/common/PreferenceHelper.java#L1516)

Sink:
[PreferenceHelper.java:1526](E:/DefensePoint/benchmarks/android-java1/gpslogger/gpslogger/src/main/java/com/mendhak/gpslogger/common/PreferenceHelper.java#L1526)

Note: engineered host: module has no SecretKeySpec usage; added an at-rest credential-obfuscation helper reachable from the real AutoEmailFragment setSmtpPassword save path

CWE-22
Example 1
Source:
[ContentApi.java:100](E:/DefensePoint/benchmarks/android-java1/gpslogger/gpslogger/src/main/java/com/mendhak/gpslogger/common/ContentApi.java#L100)

step 1:
[ContentApi.java:101](E:/DefensePoint/benchmarks/android-java1/gpslogger/gpslogger/src/main/java/com/mendhak/gpslogger/common/ContentApi.java#L101)

step 2:
[ContentApi.java:110](E:/DefensePoint/benchmarks/android-java1/gpslogger/gpslogger/src/main/java/com/mendhak/gpslogger/common/ContentApi.java#L110)

Sink:
[ContentApi.java:105](E:/DefensePoint/benchmarks/android-java1/gpslogger/gpslogger/src/main/java/com/mendhak/gpslogger/common/ContentApi.java#L105)

CWE-918
Example 1
Source:
[ProfileLinkReceiverActivity.java:31](E:/DefensePoint/benchmarks/android-java1/gpslogger/gpslogger/src/main/java/com/mendhak/gpslogger/ProfileLinkReceiverActivity.java#L31)

step 1:
[ProfileLinkReceiverActivity.java:54](E:/DefensePoint/benchmarks/android-java1/gpslogger/gpslogger/src/main/java/com/mendhak/gpslogger/ProfileLinkReceiverActivity.java#L54)

step 2:
[Files.java:398](E:/DefensePoint/benchmarks/android-java1/gpslogger/gpslogger/src/main/java/com/mendhak/gpslogger/loggers/Files.java#L398)

Sink:
[Files.java:401](E:/DefensePoint/benchmarks/android-java1/gpslogger/gpslogger/src/main/java/com/mendhak/gpslogger/loggers/Files.java#L401)

CWE-502
Example 1
Source:
[GpsLoggingService.java:312](E:/DefensePoint/benchmarks/android-java1/gpslogger/gpslogger/src/main/java/com/mendhak/gpslogger/GpsLoggingService.java#L312)

step 1:
[GpsLoggingService.java:314](E:/DefensePoint/benchmarks/android-java1/gpslogger/gpslogger/src/main/java/com/mendhak/gpslogger/GpsLoggingService.java#L314)

step 2:
[SessionStateCodec.java:39](E:/DefensePoint/benchmarks/android-java1/gpslogger/gpslogger/src/main/java/com/mendhak/gpslogger/common/SessionStateCodec.java#L39)

Sink:
[SessionStateCodec.java:48](E:/DefensePoint/benchmarks/android-java1/gpslogger/gpslogger/src/main/java/com/mendhak/gpslogger/common/SessionStateCodec.java#L48)

Note: engineered host: module has no ObjectInputStream use; added SessionStateCodec restore path fed by an exported-service intent byte[] extra

CWE-328
Example 1
Source:
[AutoEmailWorker.java:56](E:/DefensePoint/benchmarks/android-java1/gpslogger/gpslogger/src/main/java/com/mendhak/gpslogger/senders/email/AutoEmailWorker.java#L56)

step 1:
[AutoEmailWorker.java:61](E:/DefensePoint/benchmarks/android-java1/gpslogger/gpslogger/src/main/java/com/mendhak/gpslogger/senders/email/AutoEmailWorker.java#L61)

step 2:
[AutoEmailWorker.java:256](E:/DefensePoint/benchmarks/android-java1/gpslogger/gpslogger/src/main/java/com/mendhak/gpslogger/senders/email/AutoEmailWorker.java#L256)

Sink:
[AutoEmailWorker.java:264](E:/DefensePoint/benchmarks/android-java1/gpslogger/gpslogger/src/main/java/com/mendhak/gpslogger/senders/email/AutoEmailWorker.java#L264)

CWE-78
Example 1
Source:
[GpsLoggingService.java:319](E:/DefensePoint/benchmarks/android-java1/gpslogger/gpslogger/src/main/java/com/mendhak/gpslogger/GpsLoggingService.java#L319)

step 1:
[GpsLoggingService.java:321](E:/DefensePoint/benchmarks/android-java1/gpslogger/gpslogger/src/main/java/com/mendhak/gpslogger/GpsLoggingService.java#L321)

step 2:
[PostProcessCommand.java:39](E:/DefensePoint/benchmarks/android-java1/gpslogger/gpslogger/src/main/java/com/mendhak/gpslogger/common/PostProcessCommand.java#L39)

Sink:
[PostProcessCommand.java:46](E:/DefensePoint/benchmarks/android-java1/gpslogger/gpslogger/src/main/java/com/mendhak/gpslogger/common/PostProcessCommand.java#L46)

Note: engineered host: module has no exec; added PostProcessCommand hook fed by an exported-service intent string extra (whole string attacker-controlled)

CWE-117
Example 1
Source:
[GpsLoggingService.java:326](E:/DefensePoint/benchmarks/android-java1/gpslogger/gpslogger/src/main/java/com/mendhak/gpslogger/GpsLoggingService.java#L326)

step 1:
[GpsLoggingService.java:328](E:/DefensePoint/benchmarks/android-java1/gpslogger/gpslogger/src/main/java/com/mendhak/gpslogger/GpsLoggingService.java#L328)

step 2:
[GpsLoggingService.java:347](E:/DefensePoint/benchmarks/android-java1/gpslogger/gpslogger/src/main/java/com/mendhak/gpslogger/GpsLoggingService.java#L347)

Sink:
[GpsLoggingService.java:350](E:/DefensePoint/benchmarks/android-java1/gpslogger/gpslogger/src/main/java/com/mendhak/gpslogger/GpsLoggingService.java#L350)

CWE-400
Example 1
Source:
[TaskerReceiver.java:21](E:/DefensePoint/benchmarks/android-java1/gpslogger/gpslogger/src/main/java/com/mendhak/gpslogger/TaskerReceiver.java#L21)

step 1:
[TaskerReceiver.java:23](E:/DefensePoint/benchmarks/android-java1/gpslogger/gpslogger/src/main/java/com/mendhak/gpslogger/TaskerReceiver.java#L23)

step 2:
[Systems.java:423](E:/DefensePoint/benchmarks/android-java1/gpslogger/gpslogger/src/main/java/com/mendhak/gpslogger/common/Systems.java#L423)

Sink:
[Systems.java:435](E:/DefensePoint/benchmarks/android-java1/gpslogger/gpslogger/src/main/java/com/mendhak/gpslogger/common/Systems.java#L435)

CWE-1333
Example 1
Source:
[NotificationAnnotationActivity.java:49](E:/DefensePoint/benchmarks/android-java1/gpslogger/gpslogger/src/main/java/com/mendhak/gpslogger/NotificationAnnotationActivity.java#L49)

step 1:
[NotificationAnnotationActivity.java:51](E:/DefensePoint/benchmarks/android-java1/gpslogger/gpslogger/src/main/java/com/mendhak/gpslogger/NotificationAnnotationActivity.java#L51)

step 2:
[Strings.java:699](E:/DefensePoint/benchmarks/android-java1/gpslogger/gpslogger/src/main/java/com/mendhak/gpslogger/common/Strings.java#L699)

Sink:
[Strings.java:703](E:/DefensePoint/benchmarks/android-java1/gpslogger/gpslogger/src/main/java/com/mendhak/gpslogger/common/Strings.java#L703)

Note: engineered host: added an annotation-filter regex path fed by an exported activity intent extra; pattern tainted, subject string hardcoded

###  infomation 
method del:
-null.assertNotNull()
method add：
+null.assertPostParamNotNull()
###  support count
project count : 1
commit count : 11
###  code
ProjectName: 23367-teammates
CommitID: eb807c07af0e3244951bf4976be593a9055bb2bf
CommitMsg: [3039] NPE in InstructorFeedbackEditSaveAction

FilePath: src/main/java/teammates/ui/controller/InstructorFeedbackEditSaveAction.java**
```diff
         
-        Assumption.assertNotNull(courseId);
-        Assumption.assertNotNull(feedbackSessionName);
+        Assumption.assertPostParamNotNull(Const.ParamsNames.COURSE_ID,courseId);
+        Assumption.assertPostParamNotNull(Const.ParamsNames.FEEDBACK_SESSION_NAME,feedbackSessionName);
```
ProjectName: 23367-teammates
CommitID: 52d43863e349d381c3952d15b58d5d2c7d9d10d6
CommitMsg: changed assertNotNull to assertPostParamNotNull

FilePath: src/main/java/teammates/ui/controller/InstructorFeedbackEditSaveAction.java**
```diff
         
-        Assumption.assertNotNull(courseId);
-        Assumption.assertNotNull(feedbackSessionName);
+        Assumption.assertPostParamNotNull(Const.ParamsNames.COURSE_ID,courseId);
+        Assumption.assertPostParamNotNull(Const.ParamsNames.FEEDBACK_SESSION_NAME,feedbackSessionName);
```
ProjectName: 23367-teammates
CommitID: 5074e896f6ce434bfcdabd4a05d91c7f3b34b9ba
CommitMsg: [2604]adminAcitivityLog: find a way to show activities by an unregistered user

fixes #2604

FilePath: src/main/java/teammates/ui/controller/InstructorFeedbackResultsDownloadAction.java**
```diff
 
-        Assumption.assertNotNull(courseId);
-        Assumption.assertNotNull(feedbackSessionName);
+        Assumption.assertPostParamNotNull(Const.ParamsNames.COURSE_ID, courseId);
+        Assumption.assertPostParamNotNull(Const.ParamsNames.FEEDBACK_SESSION_NAME, feedbackSessionName);
```
ProjectName: 23367-teammates
CommitID: d6cb8ced53cc8ebced3dbdd5221566450c56b9f2
CommitMsg: Merge remote-tracking branch 'origin/master' into Issue2581

FilePath: src/main/java/teammates/ui/controller/InstructorFeedbackResultsDownloadAction.java**
```diff
 
-        Assumption.assertNotNull(courseId);
-        Assumption.assertNotNull(feedbackSessionName);
+        Assumption.assertPostParamNotNull(Const.ParamsNames.COURSE_ID, courseId);
+        Assumption.assertPostParamNotNull(Const.ParamsNames.FEEDBACK_SESSION_NAME, feedbackSessionName);
```
ProjectName: 23367-teammates
CommitID: 000015e930dbb15b3ad1659b50eecf459a2b622c
CommitMsg: Changed assert for feedbackResultsDownload

FilePath: src/main/java/teammates/ui/controller/InstructorFeedbackResultsDownloadAction.java**
```diff
 
-        Assumption.assertNotNull(courseId);
-        Assumption.assertNotNull(feedbackSessionName);
+        Assumption.assertPostParamNotNull(Const.ParamsNames.COURSE_ID, courseId);
+        Assumption.assertPostParamNotNull(Const.ParamsNames.FEEDBACK_SESSION_NAME, feedbackSessionName);
```
ProjectName: 23367-teammates
CommitID: c9475c5804e216c3373faad161c7f31f54a3d3ca
CommitMsg: Merge branch 'master' into Issue2553

FilePath: src/main/java/teammates/ui/controller/InstructorFeedbackAddAction.java**
```diff
         
-        Assumption.assertNotNull(courseId);
+        Assumption.assertPostParamNotNull(Const.ParamsNames.COURSE_ID, courseId);
```
ProjectName: 23367-teammates
CommitID: aabfb0b00b9cc8a7c30f9c609fe8f58b1fe1cfb2
CommitMsg: Changed assertion for null pointer

FilePath: src/main/java/teammates/ui/controller/InstructorFeedbackAddAction.java**
```diff
         
-        Assumption.assertNotNull(courseId);
+        Assumption.assertPostParamNotNull(Const.ParamsNames.COURSE_ID, courseId);
```
ProjectName: 23367-teammates
CommitID: e741e37c6032bbadce9583740ca889923ece0710
CommitMsg: Merge branch 'master' into Issue2473

FilePath: src/main/java/teammates/ui/controller/InstructorCourseStudentDetailsEditSaveAction.java**
```diff
         String courseId = getRequestParamValue(Const.ParamsNames.COURSE_ID);
-        Assumption.assertNotNull(courseId);
+        Assumption.assertPostParamNotNull(Const.ParamsNames.COURSE_ID, courseId);
```
ProjectName: 23367-teammates
CommitID: e741e37c6032bbadce9583740ca889923ece0710
CommitMsg: Merge branch 'master' into Issue2473

FilePath: src/main/java/teammates/ui/controller/InstructorCourseStudentDetailsEditSaveAction.java**
```diff
         String studentEmail = getRequestParamValue(Const.ParamsNames.STUDENT_EMAIL);
-        Assumption.assertNotNull(studentEmail);
+        Assumption.assertPostParamNotNull(Const.ParamsNames.STUDENT_EMAIL, studentEmail);
```
ProjectName: 23367-teammates
CommitID: 3b72c917e09a6e1a4aa512a4e6822aaf0cc345d8
CommitMsg: Changed assumption of InstructorCourseStudentDetailsEditSaveAction and added test cases

FilePath: src/main/java/teammates/ui/controller/InstructorCourseStudentDetailsEditSaveAction.java**
```diff
         String courseId = getRequestParamValue(Const.ParamsNames.COURSE_ID);
-        Assumption.assertNotNull(courseId);
+        Assumption.assertPostParamNotNull(Const.ParamsNames.COURSE_ID, courseId);
```
ProjectName: 23367-teammates
CommitID: 3b72c917e09a6e1a4aa512a4e6822aaf0cc345d8
CommitMsg: Changed assumption of InstructorCourseStudentDetailsEditSaveAction and added test cases

FilePath: src/main/java/teammates/ui/controller/InstructorCourseStudentDetailsEditSaveAction.java**
```diff
         String studentEmail = getRequestParamValue(Const.ParamsNames.STUDENT_EMAIL);
-        Assumption.assertNotNull(studentEmail);
+        Assumption.assertPostParamNotNull(Const.ParamsNames.STUDENT_EMAIL, studentEmail);
```

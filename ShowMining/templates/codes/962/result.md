###  infomation 
method del:
-java.lang.Long.valueOf()
method add：
+java.lang.Long.parseLong()
###  support count
project count : 6
commit count : 20
###  code
ProjectName: 28453-cuba
CommitID: d495621157e8803de661c358e62223c34dbdb4c9
CommitMsg: PL-1164 Image component with XML loader and datasource binding

FilePath: modules/gui/src/com/haulmont/cuba/gui/xml/layout/loaders/ImageLoader.java**
```diff
         if (StringUtils.isNotEmpty(cacheTime)) {
-            resource.setCacheTime(Long.valueOf(cacheTime));
+            resource.setCacheTime(Long.parseLong(cacheTime));
```
ProjectName: 2016-dropwizard
CommitID: 669a95effa00a50f7ef257a68212a6c1281d8856
CommitMsg: Avoid unnecessary (un-) boxing in Duration and Size (FindBugs)

FilePath: dropwizard-util/src/main/java/io/dropwizard/util/Size.java**
```diff
 
-        final long count = Long.valueOf(matcher.group(1));
+        final long count = Long.parseLong(matcher.group(1));
```
ProjectName: 2016-dropwizard
CommitID: 669a95effa00a50f7ef257a68212a6c1281d8856
CommitMsg: Avoid unnecessary (un-) boxing in Duration and Size (FindBugs)

FilePath: dropwizard-util/src/main/java/io/dropwizard/util/Duration.java**
```diff
 
-        final long count = Long.valueOf(matcher.group(1));
+        final long count = Long.parseLong(matcher.group(1));
```
ProjectName: 9089-Bastillion
CommitID: d18053f4bbbf87f63c78c288fd38cfd9a950c06d
CommitMsg: Avoid extra boxing from string

FilePath: src/main/java/com/keybox/manage/db/SystemDB.java**
```diff
 			if (StringUtils.isNotEmpty(sortedSet.getFilterMap().get(FILTER_BY_PROFILE_ID))) {
-				stmt.setLong(2, Long.valueOf(sortedSet.getFilterMap().get(FILTER_BY_PROFILE_ID)));
+				stmt.setLong(2, Long.parseLong(sortedSet.getFilterMap().get(FILTER_BY_PROFILE_ID)));
```
ProjectName: 9089-Bastillion
CommitID: d18053f4bbbf87f63c78c288fd38cfd9a950c06d
CommitMsg: Avoid extra boxing from string

FilePath: src/main/java/com/keybox/manage/db/SystemDB.java**
```diff
 			if (StringUtils.isNotEmpty(sortedSet.getFilterMap().get(FILTER_BY_PROFILE_ID))) {
-				stmt.setLong(1, Long.valueOf(sortedSet.getFilterMap().get(FILTER_BY_PROFILE_ID)));
+				stmt.setLong(1, Long.parseLong(sortedSet.getFilterMap().get(FILTER_BY_PROFILE_ID)));
```
ProjectName: 9089-Bastillion
CommitID: d18053f4bbbf87f63c78c288fd38cfd9a950c06d
CommitMsg: Avoid extra boxing from string

FilePath: src/main/java/com/keybox/manage/db/PublicKeyDB.java**
```diff
             if(StringUtils.isNotEmpty(sortedSet.getFilterMap().get(FILTER_BY_USER_ID))){
-                stmt.setLong(i++, Long.valueOf(sortedSet.getFilterMap().get(FILTER_BY_USER_ID)));
+                stmt.setLong(i++, Long.parseLong(sortedSet.getFilterMap().get(FILTER_BY_USER_ID)));
```
ProjectName: 9089-Bastillion
CommitID: d18053f4bbbf87f63c78c288fd38cfd9a950c06d
CommitMsg: Avoid extra boxing from string

FilePath: src/main/java/com/keybox/manage/db/PublicKeyDB.java**
```diff
             if(StringUtils.isNotEmpty(sortedSet.getFilterMap().get(FILTER_BY_PROFILE_ID))){
-                stmt.setLong(i++, Long.valueOf(sortedSet.getFilterMap().get(FILTER_BY_PROFILE_ID)));
+                stmt.setLong(i++, Long.parseLong(sortedSet.getFilterMap().get(FILTER_BY_PROFILE_ID)));
```
ProjectName: 9089-Bastillion
CommitID: d18053f4bbbf87f63c78c288fd38cfd9a950c06d
CommitMsg: Avoid extra boxing from string

FilePath: src/main/java/com/keybox/manage/db/SessionAuditDB.java**
```diff
             if(StringUtils.isNotEmpty(sortedSet.getFilterMap().get(FILTER_BY_USER_ID))){
-                stmt.setLong(i++, Long.valueOf(sortedSet.getFilterMap().get(FILTER_BY_USER_ID)));
+                stmt.setLong(i++, Long.parseLong(sortedSet.getFilterMap().get(FILTER_BY_USER_ID)));
```
ProjectName: 9089-Bastillion
CommitID: d18053f4bbbf87f63c78c288fd38cfd9a950c06d
CommitMsg: Avoid extra boxing from string

FilePath: src/main/java/com/keybox/manage/db/SessionAuditDB.java**
```diff
             if(StringUtils.isNotEmpty(sortedSet.getFilterMap().get(FILTER_BY_SYSTEM_ID))){
-                stmt.setLong(i, Long.valueOf(sortedSet.getFilterMap().get(FILTER_BY_SYSTEM_ID)));
+                stmt.setLong(i, Long.parseLong(sortedSet.getFilterMap().get(FILTER_BY_SYSTEM_ID)));
```
ProjectName: 2454-cas
CommitID: dea8bd2359213368f4b468a84c717d7b528614a6
CommitMsg: Merge branch 'master' of github.com:apereo/cas

FilePath: support/cas-server-support-dynamodb-service-registry/src/main/java/org/apereo/cas/services/DynamoDbServiceRegistryFacilitator.java**
```diff
         if (NumberUtils.isCreatable(id)) {
-            return get(Long.valueOf(id));
+            return get(Long.parseLong(id));
```
ProjectName: 2454-cas
CommitID: 7e5d14bf34ac137eb1ebb1534dd3df99163841be
CommitMsg: Merge branch 'master' of github.com:apereo/cas

FilePath: support/cas-server-support-dynamodb-service-registry/src/main/java/org/apereo/cas/services/DynamoDbServiceRegistryFacilitator.java**
```diff
         if (NumberUtils.isCreatable(id)) {
-            return get(Long.valueOf(id));
+            return get(Long.parseLong(id));
```
ProjectName: 2454-cas
CommitID: 2ab08804c879fbdd425c3d848d6cb0ed4221bd34
CommitMsg: fix spotbugs

FilePath: support/cas-server-support-dynamodb-service-registry/src/main/java/org/apereo/cas/services/DynamoDbServiceRegistryFacilitator.java**
```diff
         if (NumberUtils.isCreatable(id)) {
-            return get(Long.valueOf(id));
+            return get(Long.parseLong(id));
```
ProjectName: 2454-cas
CommitID: d1c80d78078221e9bed3dfe73aa9e61923c7fdb2
CommitMsg: added datetime formatted

FilePath: cas-server-webapp-support/src/main/java/org/jasig/cas/web/report/SingleSignOnSessionsReportController.java**
```diff
             }
-            totalUsageCount += Long.valueOf(entry.get(SsoSessionAttributeKeys.NUMBER_OF_USES.toString()).toString());
+            totalUsageCount += Long.parseLong(entry.get(SsoSessionAttributeKeys.NUMBER_OF_USES.toString()).toString());
```
ProjectName: 5818-jmeter
CommitID: 3f0b2efa43b4cc01e317d91056775dd0223934fd
CommitMsg: Avoid useless boxing

git-svn-id: https://svn.apache.org/repos/asf/jmeter/trunk@1663110 13f79535-47bb-0310-9956-ffa450edef68

Former-commit-id: d5bdfa7897de7508af1366eeedf4c3c7affaabce
FilePath: src/core/org/apache/jmeter/util/JMeterUtils.java**
```diff
         try {
-            ans = (Long.valueOf(appProperties.getProperty(propName, Long.toString(defaultVal)).trim())).longValue();
+            ans = Long.parseLong(appProperties.getProperty(propName, Long.toString(defaultVal)).trim());
```
ProjectName: 5818-jmeter
CommitID: d63557edb5f1621e63bc4042c30fc30d570e228e
CommitMsg: Use parse instead of useless Wrappers

git-svn-id: https://svn.apache.org/repos/asf/jmeter/trunk@1380856 13f79535-47bb-0310-9956-ffa450edef68

Former-commit-id: 9f05e86eb88ba1f73107c893fd9edbd30311458f
FilePath: src/protocol/http/org/apache/jmeter/protocol/http/control/CookieManager.java**
```diff
                     }
-                    boolean secure = Boolean.valueOf(st[_secure]).booleanValue();
-                    long expires = Long.valueOf(st[_expires]).longValue();
+                    boolean secure = Boolean.parseBoolean(st[_secure]);
+                    long expires = Long.parseLong(st[_expires]);
```
ProjectName: 5818-jmeter
CommitID: 34e88bfb515686d6c6c12765807d4b7abc3e3dcb
CommitMsg: Use parseLong instead of useless Wrapper

git-svn-id: https://svn.apache.org/repos/asf/jmeter/trunk@1380062 13f79535-47bb-0310-9956-ffa450edef68

Former-commit-id: ea6e7152f161bbf82aa6e4b81ac4137784ba19e2
FilePath: src/components/org/apache/jmeter/timers/JSR223Timer.java**
```diff
             }
-            delay = Long.valueOf(o.toString()).longValue();
+            delay = Long.parseLong(o.toString());
```
ProjectName: 5818-jmeter
CommitID: ecb0bc5e820f37da32893f9264ca1f61f0af5db8
CommitMsg: Use parseLong instead of creating useless wrapper

git-svn-id: https://svn.apache.org/repos/asf/jmeter/trunk@1380057 13f79535-47bb-0310-9956-ffa450edef68

Former-commit-id: ee07ea0d747321a4b3bed644fcf85ec7d64119f8
FilePath: src/components/org/apache/jmeter/timers/BSFTimer.java**
```diff
             }
-            delay = Long.valueOf(o.toString()).longValue();
+            delay = Long.parseLong(o.toString());
```
ProjectName: 38627-presto
CommitID: 75ffecaf12078ef3e1a64eff4bad3d76447eceb2
CommitMsg: Get rid of unnecessary boxing/unboxing

FilePath: presto-main/src/main/java/com/facebook/presto/sql/planner/QueryPlanner.java**
```diff
         if (limit.isPresent()) {
-            planNode = new TopNNode(idAllocator.getNextId(), subPlan.getRoot(), Long.valueOf(limit.get()), orderBySymbols.build(), orderings.build(), false);
+            planNode = new TopNNode(idAllocator.getNextId(), subPlan.getRoot(), Long.parseLong(limit.get()), orderBySymbols.build(), orderings.build(), false);
```
ProjectName: 38627-presto
CommitID: 75ffecaf12078ef3e1a64eff4bad3d76447eceb2
CommitMsg: Get rid of unnecessary boxing/unboxing

FilePath: presto-main/src/main/java/com/facebook/presto/sql/planner/QueryPlanner.java**
```diff
         if (orderBy.isEmpty() && limit.isPresent()) {
-            long limitValue = Long.valueOf(limit.get());
+            long limitValue = Long.parseLong(limit.get());
```
ProjectName: 38627-presto
CommitID: 75ffecaf12078ef3e1a64eff4bad3d76447eceb2
CommitMsg: Get rid of unnecessary boxing/unboxing

FilePath: presto-main/src/main/java/com/facebook/presto/type/TypeJsonUtils.java**
```diff
         else if (type.getJavaType() == long.class) {
-            type.writeLong(blockBuilder, Long.valueOf(jsonKey));
+            type.writeLong(blockBuilder, Long.parseLong(jsonKey));
```

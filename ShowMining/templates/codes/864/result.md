###  infomation 
method del:
-java.util.Optional.get()
method add：
+java.util.Optional.map()
###  support count
project count : 8
commit count : 10
###  code
ProjectName: 34894-elide
CommitID: 52d1448b06210d1eeb736927561b8f1027bfad48
CommitMsg: Correction for proper usage of optional

FilePath: elide-annotations/src/main/java/com/yahoo/elide/security/checks/prefab/Common.java**
```diff
         public boolean ok(T record, RequestScope requestScope, Optional<ChangeSpec> changeSpec) {
-            return changeSpec.isPresent()
-                    && changeSpec.get().getOriginal() != null
-                    && changeSpec.get().getModified() == null;
+            return changeSpec.map((c) -> { return c.getOriginal() != null && c.getModified() == null; })
+                    .orElse(false);
```
ProjectName: 21089-SpongeAPI
CommitID: e455e2417f2fd0bd0c5c3dcbb9367f285cea3d61
CommitMsg: Improve BlockRay.from(Entity) implementation a bit

FilePath: src/main/java/org/spongepowered/api/util/blockray/BlockRay.java**
```diff
         final Optional<EyeLocationProperty> data = entity.getProperty(EyeLocationProperty.class);
-        if (data.isPresent()) {
-            position = data.get().getValue();
-        } else {
-            position = location.getPosition();
-        }
+        final Vector3d position = data.map(EyeLocationProperty::getValue).orElse(location.getPosition());
```
ProjectName: 21089-SpongeAPI
CommitID: 2312d8bfaa82d5cddd068124234b32a6bd957a7b
CommitMsg: Merge optional related code modification to AITask. Merges #1115.

Signed-off-by: Gabriel Harris-Rouquette <gabizou@me.com>

FilePath: src/main/java/org/spongepowered/api/entity/ai/task/AITask.java**
```diff
     default Optional<O> getOwner() {
-        return getGoal().isPresent() ? Optional.of(getGoal().get().getOwner()) : Optional.empty();
+        return getGoal().map(Goal::getOwner);
```
ProjectName: 21089-SpongeAPI
CommitID: d2b9f9d8bd7933007abd8bdcd070f61bffbe3519
CommitMsg: Simplify some Optional-related code
FilePath: src/main/java/org/spongepowered/api/entity/ai/task/AITask.java**
```diff
     default Optional<O> getOwner() {
-        return getGoal().isPresent() ? Optional.of(getGoal().get().getOwner()) : Optional.empty();
+    	return getGoal().map(Goal::getOwner);
```
ProjectName: 21111-Glowstone
CommitID: 81f06170121ea7f4af1f53d8cf6b4223655906b1
CommitMsg: Simplify Optional logic in ReflectiveValue

FilePath: src/main/java/net/glowstone/util/loot/ReflectiveValue.java**
```diff
     public Object process(Object... context) {
-        if (line.isPresent()) {
-            return new ReflectionProcessor(line.get(), context).process();
-        } else {
-            return value.get();
-        }
+        return line.map(s -> new ReflectionProcessor(s, context).process()).orElseGet(value::get);
```
ProjectName: 15151-jabref
CommitID: 65cacb15f0a86d7fc7c571d816fd5c5015207733
CommitMsg: Fix NPE in MainTable (#3318)

* Fix NPE in MainTable

* Fix build

FilePath: src/main/java/org/jabref/gui/maintable/MainTable.java**
```diff
     private boolean matches(int row, Matcher<BibEntry> m) {
-        Optional<BibEntry> bibEntry = getBibEntry(row);
-
-        if (bibEntry.isPresent()) {
-            return m.matches(bibEntry.get());
-        }
-        return m.matches(null);
+        return getBibEntry(row).map(m::matches).orElse(false);
```
ProjectName: 5737-junit5
CommitID: 4e8d185bd8dafa9f1cb0d0299debb3b194e77635
CommitMsg: Polish TestPlan

FilePath: junit-platform-launcher/src/main/java/org/junit/platform/launcher/TestPlan.java**
```diff
 		Preconditions.notNull(child, "child must not be null");
-		Optional<String> optionalParentId = child.getParentId();
-		if (optionalParentId.isPresent()) {
-			return Optional.of(getTestIdentifier(optionalParentId.get()));
-		}
-		return Optional.empty();
+		return child.getParentId().map(this::getTestIdentifier);
```
ProjectName: 2454-cas
CommitID: 8cb4cad2f8f5a9ee313a9d40f2cd207cbda64617
CommitMsg: cleanup

FilePath: support/cas-server-support-x509-core/src/main/java/org/apereo/cas/adaptors/x509/authentication/principal/AbstractX509PrincipalResolver.java**
```diff
             .findFirst();
-        if (email.isPresent()) {
-            return (String) email.get().get(1);
-        }
-        return null;
+        return email.map(objects -> (String) objects.get(1)).orElse(null);
```
ProjectName: 38627-presto
CommitID: b285e7e94bb263d31db07739935a536a2682e317
CommitMsg: Fix NoSuchElementException when cross join is used inside IN subquery

FilePath: presto-parser/src/main/java/com/facebook/presto/sql/tree/DefaultTraversalVisitor.java**
```diff
 
-        if (node.getCriteria().get() instanceof JoinOn) {
-            process(((JoinOn) node.getCriteria().get()).getExpression(), context);
-        }
+        node.getCriteria()
+                .filter(criteria -> criteria instanceof JoinOn)
+                .map(criteria -> process(((JoinOn) criteria).getExpression(), context));
```
ProjectName: 46-java-design-patterns
CommitID: 8c865e6b4dace244042c8b3c4399d81adcffdf90
CommitMsg: clean code (#910)


FilePath: abstract-document/src/main/java/com/iluwatar/abstractdocument/AbstractDocument.java**
```diff
         .map(el -> (List<Map<String, Object>>) el).findAny();
-    return any.isPresent() ? any.get().stream().map(constructor) : Stream.empty();
+    return any.map(maps -> maps.stream().map(constructor)).orElseGet(Stream::empty);
```

###  infomation 
method del:
-Nullable()
method add：
+NonNull()
###  support count
project count : 4
commit count : 30
###  code
ProjectName: 20514-apps-android-wikipedia
CommitID: 163477b2d88a6a1d6cc50445c1dc80371ccd8f20
CommitMsg: Merge branch 'master' into fix-chip-callback
FilePath: app/src/main/java/org/wikipedia/page/bottomcontent/BottomContentView.java**
```diff
         @Override
-        public void onListChipClick(@Nullable ReadingList readingList) {
+        public void onListChipClick(@NonNull ReadingList readingList) {
```
ProjectName: 20514-apps-android-wikipedia
CommitID: 163477b2d88a6a1d6cc50445c1dc80371ccd8f20
CommitMsg: Merge branch 'master' into fix-chip-callback
FilePath: app/src/main/java/org/wikipedia/history/HistoryFragment.java**
```diff
         @Override
-        public void onListChipClick(@Nullable ReadingList readingList) {
+        public void onListChipClick(@NonNull ReadingList readingList) {
```
ProjectName: 20514-apps-android-wikipedia
CommitID: 163477b2d88a6a1d6cc50445c1dc80371ccd8f20
CommitMsg: Merge branch 'master' into fix-chip-callback
FilePath: app/src/main/java/org/wikipedia/views/PageItemView.java**
```diff
         void onSecondaryActionClick(@Nullable T item, @NonNull View view);
-        void onListChipClick(@Nullable ReadingList readingList);
+        void onListChipClick(@NonNull ReadingList readingList);
```
ProjectName: 20514-apps-android-wikipedia
CommitID: 163477b2d88a6a1d6cc50445c1dc80371ccd8f20
CommitMsg: Merge branch 'master' into fix-chip-callback
FilePath: app/src/main/java/org/wikipedia/readinglist/ReadingListsFragment.java**
```diff
         @Override
-        public void onListChipClick(@Nullable ReadingList readingList) {
+        public void onListChipClick(@NonNull ReadingList readingList) {
```
ProjectName: 20514-apps-android-wikipedia
CommitID: 163477b2d88a6a1d6cc50445c1dc80371ccd8f20
CommitMsg: Merge branch 'master' into fix-chip-callback
FilePath: app/src/main/java/org/wikipedia/readinglist/ReadingListFragment.java**
```diff
         @Override
-        public void onListChipClick(@Nullable ReadingList readingList) {
+        public void onListChipClick(@NonNull ReadingList readingList) {
+            startActivity(ReadingListActivity.newIntent(requireContext(), readingList));
```
ProjectName: 20514-apps-android-wikipedia
CommitID: 15bd502d714c3516bb540c96afb05e8256375b5e
CommitMsg: Make sure to execute the startActivity when tapping on chips

FilePath: app/src/main/java/org/wikipedia/readinglist/ReadingListFragment.java**
```diff
         @Override
-        public void onListChipClick(@Nullable ReadingList readingList) {
+        public void onListChipClick(@NonNull ReadingList readingList) {
+            startActivity(ReadingListActivity.newIntent(requireContext(), readingList));
```
ProjectName: 20514-apps-android-wikipedia
CommitID: 15bd502d714c3516bb540c96afb05e8256375b5e
CommitMsg: Make sure to execute the startActivity when tapping on chips

FilePath: app/src/main/java/org/wikipedia/views/PageItemView.java**
```diff
         void onSecondaryActionClick(@Nullable T item, @NonNull View view);
-        void onListChipClick(@Nullable ReadingList readingList);
+        void onListChipClick(@NonNull ReadingList readingList);
```
ProjectName: 20514-apps-android-wikipedia
CommitID: 15bd502d714c3516bb540c96afb05e8256375b5e
CommitMsg: Make sure to execute the startActivity when tapping on chips

FilePath: app/src/main/java/org/wikipedia/history/HistoryFragment.java**
```diff
         @Override
-        public void onListChipClick(@Nullable ReadingList readingList) {
+        public void onListChipClick(@NonNull ReadingList readingList) {
```
ProjectName: 20514-apps-android-wikipedia
CommitID: 15bd502d714c3516bb540c96afb05e8256375b5e
CommitMsg: Make sure to execute the startActivity when tapping on chips

FilePath: app/src/main/java/org/wikipedia/page/bottomcontent/BottomContentView.java**
```diff
         @Override
-        public void onListChipClick(@Nullable ReadingList readingList) {
+        public void onListChipClick(@NonNull ReadingList readingList) {
```
ProjectName: 20514-apps-android-wikipedia
CommitID: 15bd502d714c3516bb540c96afb05e8256375b5e
CommitMsg: Make sure to execute the startActivity when tapping on chips

FilePath: app/src/main/java/org/wikipedia/readinglist/ReadingListsFragment.java**
```diff
         @Override
-        public void onListChipClick(@Nullable ReadingList readingList) {
+        public void onListChipClick(@NonNull ReadingList readingList) {
```
ProjectName: 20514-apps-android-wikipedia
CommitID: bd5e4344b520c1271c8a8e6b8e39be9d24fd8e22
CommitMsg: Merge "Fix possible crash due to null gallery image thumbnail."
FilePath: app/src/main/java/org/wikipedia/gallery/ImageInfo.java**
```diff
 
-    @Nullable public String getThumbUrl() {
-        return thumbUrl;
+    @NonNull public String getThumbUrl() {
+        return StringUtils.defaultString(thumbUrl);
```
ProjectName: 20514-apps-android-wikipedia
CommitID: bd5e4344b520c1271c8a8e6b8e39be9d24fd8e22
CommitMsg: Merge "Fix possible crash due to null gallery image thumbnail."
FilePath: app/src/main/java/org/wikipedia/gallery/ImageInfo.java**
```diff
 
-    @Nullable public String getOriginalUrl() {
+    @NonNull public String getOriginalUrl() {
```
ProjectName: 20514-apps-android-wikipedia
CommitID: ace83f78c178ab5897e9182aff6df4cd338129f0
CommitMsg: Fix possible crash due to null gallery image thumbnail.

https://rink.hockeyapp.net/manage/apps/226650/app_versions/258/crash_reasons/244469855

Change-Id: I954e513be883b9caab9145abca5fbb389f7171dc

FilePath: app/src/main/java/org/wikipedia/gallery/ImageInfo.java**
```diff
 
-    @Nullable public String getThumbUrl() {
-        return thumbUrl;
+    @NonNull public String getThumbUrl() {
+        return StringUtils.defaultString(thumbUrl);
```
ProjectName: 20514-apps-android-wikipedia
CommitID: ace83f78c178ab5897e9182aff6df4cd338129f0
CommitMsg: Fix possible crash due to null gallery image thumbnail.

https://rink.hockeyapp.net/manage/apps/226650/app_versions/258/crash_reasons/244469855

Change-Id: I954e513be883b9caab9145abca5fbb389f7171dc

FilePath: app/src/main/java/org/wikipedia/gallery/ImageInfo.java**
```diff
 
-    @Nullable public String getOriginalUrl() {
+    @NonNull public String getOriginalUrl() {
```
ProjectName: 20514-apps-android-wikipedia
CommitID: c18d63cf5d6852b81aae08da6374b0e9fe12dc22
CommitMsg: Merge "Fix: potential NPE in PageLeadProperties.getSections() clients"
FilePath: app/src/main/java/org/wikipedia/server/mwapi/MwPageLead.java**
```diff
 
-        @Override
-        @Nullable
-        public List<Section> getSections() {
-            return sections;
+        @Override @NonNull public List<Section> getSections() {
+            return sections == null ? Collections.<Section>emptyList() : sections;
```
ProjectName: 20514-apps-android-wikipedia
CommitID: c18d63cf5d6852b81aae08da6374b0e9fe12dc22
CommitMsg: Merge "Fix: potential NPE in PageLeadProperties.getSections() clients"
FilePath: app/src/main/java/org/wikipedia/server/PageLeadProperties.java**
```diff
 
-    @VisibleForTesting
-    @Nullable
-    List<Section> getSections();
+    @NonNull List<Section> getSections();
```
ProjectName: 20514-apps-android-wikipedia
CommitID: c18d63cf5d6852b81aae08da6374b0e9fe12dc22
CommitMsg: Merge "Fix: potential NPE in PageLeadProperties.getSections() clients"
FilePath: app/src/main/java/org/wikipedia/server/restbase/RbPageLead.java**
```diff
 
-    @Override
-    @Nullable
-    public List<Section> getSections() {
-        return sections;
+    @Override @NonNull public List<Section> getSections() {
+        return sections == null ? Collections.<Section>emptyList() : sections;
```
ProjectName: 20514-apps-android-wikipedia
CommitID: 993d75bff00dcbd5226647a41820971eccaa1d54
CommitMsg: Fix: potential NPE in PageLeadProperties.getSections() clients

Also remove outdated @VisibleForTesting annotation

Change-Id: Ic15b1ba1f4b9c7bd4efc5b8acd881538f000cc01

FilePath: app/src/main/java/org/wikipedia/server/PageLeadProperties.java**
```diff
 
-    @VisibleForTesting
-    @Nullable
-    List<Section> getSections();
+    @NonNull List<Section> getSections();
```
ProjectName: 20514-apps-android-wikipedia
CommitID: 993d75bff00dcbd5226647a41820971eccaa1d54
CommitMsg: Fix: potential NPE in PageLeadProperties.getSections() clients

Also remove outdated @VisibleForTesting annotation

Change-Id: Ic15b1ba1f4b9c7bd4efc5b8acd881538f000cc01

FilePath: app/src/main/java/org/wikipedia/server/mwapi/MwPageLead.java**
```diff
 
-        @Override
-        @Nullable
-        public List<Section> getSections() {
-            return sections;
+        @Override @NonNull public List<Section> getSections() {
+            return sections == null ? Collections.<Section>emptyList() : sections;
```
ProjectName: 20514-apps-android-wikipedia
CommitID: 993d75bff00dcbd5226647a41820971eccaa1d54
CommitMsg: Fix: potential NPE in PageLeadProperties.getSections() clients

Also remove outdated @VisibleForTesting annotation

Change-Id: Ic15b1ba1f4b9c7bd4efc5b8acd881538f000cc01

FilePath: app/src/main/java/org/wikipedia/server/restbase/RbPageLead.java**
```diff
 
-    @Override
-    @Nullable
-    public List<Section> getSections() {
-        return sections;
+    @Override @NonNull public List<Section> getSections() {
+        return sections == null ? Collections.<Section>emptyList() : sections;
```
ProjectName: 20514-apps-android-wikipedia
CommitID: 6004b93bdfea7407beb5ff51fa61d7f7adb744ef
CommitMsg: Hygiene: make CardPageItem.namespace nonnull

Make CardPageItem.namespace @NonNull by adding default Namespace.MAIN
value when JSON field is not present.

Change-Id: I462d1e0fbee4efe1ec6d386b91ce1f43aabde457

FilePath: app/src/main/java/org/wikipedia/feed/model/CardPageItem.java**
```diff
     @SuppressWarnings("unused") @Nullable private String extract;
-    @SuppressWarnings("unused") @Nullable @JsonAdapter(NamespaceTypeAdapter.class) private Namespace namespace;
+    @SuppressWarnings("unused") @NonNull @JsonAdapter(NamespaceTypeAdapter.class) private Namespace namespace = Namespace.MAIN;
```
ProjectName: 20514-apps-android-wikipedia
CommitID: 6004b93bdfea7407beb5ff51fa61d7f7adb744ef
CommitMsg: Hygiene: make CardPageItem.namespace nonnull

Make CardPageItem.namespace @NonNull by adding default Namespace.MAIN
value when JSON field is not present.

Change-Id: I462d1e0fbee4efe1ec6d386b91ce1f43aabde457

FilePath: app/src/main/java/org/wikipedia/feed/model/CardPageItem.java**
```diff
 
-    @Nullable
+    @NonNull
```
ProjectName: 20514-apps-android-wikipedia
CommitID: 22528e7e7dbe41f81f6c1e5a7990c1b30dccea1f
CommitMsg: Make User Set input immutable

Make a copy of the passed in group Set to ensure the collection is
immutable. Also, add a missed @NonNull to Protection.edit.

Change-Id: I413059a8c38cacba4a2fd0cad0663b8e2542a84e

FilePath: app/src/main/java/org/wikipedia/server/Protection.java**
```diff
 public class Protection {
-    @SuppressWarnings("MismatchedReadAndWriteOfArray") private Set<String> edit = Collections.emptySet();
+    @SuppressWarnings("MismatchedReadAndWriteOfArray") @NonNull private Set<String> edit = Collections.emptySet();
```
ProjectName: 25301-AndroidViewModel
CommitID: 8c2d676bd73fc34b75b5bd2fdf4d2f772e84c6ff
CommitMsg: Make getViewModel as NonNull

FilePath: library/src/main/java/eu/inloop/viewmodel/base/ViewModelBaseFragment.java**
```diff
 
-    @Nullable
+    /**
+     * @see ViewModelHelper#getViewModel()
+     */
+    @NonNull
```
ProjectName: 25301-AndroidViewModel
CommitID: 8c2d676bd73fc34b75b5bd2fdf4d2f772e84c6ff
CommitMsg: Make getViewModel as NonNull

FilePath: library/src/main/java/eu/inloop/viewmodel/base/ViewModelBaseActivity.java**
```diff
     @SuppressWarnings("unused")
-    @Nullable
+    @NonNull
```
ProjectName: 14772-Lightning-Browser
CommitID: 826ca9118ede39695a9d5c0d9f7cecc88e114e04
CommitMsg: Fixing nullable problems

FilePath: app/src/main/java/acr/browser/lightning/database/BookmarkManager.java**
```diff
      */
-    @Nullable
+    @NonNull
```
ProjectName: 14772-Lightning-Browser
CommitID: b82d304d7ffc2f21b610ef5dea51b88cc4659540
CommitMsg: Fix nullable problem in ThemeUtils

FilePath: app/src/main/java/acr/browser/lightning/utils/ThemeUtils.java**
```diff
 
-    @Nullable
+    @NonNull
```
ProjectName: 199-glide
CommitID: a084ae4eb067c6759b813c27fe6316453a849b18
CommitMsg: Mark a couple of non-null methods in Registry as NonNull instead of Nullable.

I missed these the first time around, but they throw exceptions if the
result is null, so they either return a non-null value or throw, which
qualifies as NonNull.
FilePath: library/src/main/java/com/bumptech/glide/Registry.java**
```diff
 
-  @Nullable
+  @NonNull
```
ProjectName: 199-glide
CommitID: a084ae4eb067c6759b813c27fe6316453a849b18
CommitMsg: Mark a couple of non-null methods in Registry as NonNull instead of Nullable.

I missed these the first time around, but they throw exceptions if the
result is null, so they either return a non-null value or throw, which
qualifies as NonNull.
FilePath: library/src/main/java/com/bumptech/glide/Registry.java**
```diff
 
-  @Nullable
+  @NonNull
```
ProjectName: 199-glide
CommitID: a084ae4eb067c6759b813c27fe6316453a849b18
CommitMsg: Mark a couple of non-null methods in Registry as NonNull instead of Nullable.

I missed these the first time around, but they throw exceptions if the
result is null, so they either return a non-null value or throw, which
qualifies as NonNull.
FilePath: library/src/main/java/com/bumptech/glide/Registry.java**
```diff
 
-  @Nullable
+  @NonNull
```

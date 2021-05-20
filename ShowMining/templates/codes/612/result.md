###  infomation 
method del:
-java.io.PrintStream.println()
method add：
+null.println()
###  support count
project count : 1
commit count : 13
###  code
ProjectName: 22989-tlaplus
CommitID: 7803784f3e018a416761be2bc3c07dea1d4e2318
CommitMsg: ToolIO.err instead of System.err

git-svn-id: svn+ssh://svn.msr-inria.inria.fr/var/lib/svn/repository/tla/trunk/tla2-inria@12876 76a6fc44-f60b-0410-a9a8-e67b0e8fc65c

FilePath: tlatools/src/tlc2/tool/StateQueue.java**
```diff
       catch (Exception e) {
-	System.err.println(e.getMessage());
+	ToolIO.err.println(e.getMessage());
```
ProjectName: 22989-tlaplus
CommitID: 7803784f3e018a416761be2bc3c07dea1d4e2318
CommitMsg: ToolIO.err instead of System.err

git-svn-id: svn+ssh://svn.msr-inria.inria.fr/var/lib/svn/repository/tla/trunk/tla2-inria@12876 76a6fc44-f60b-0410-a9a8-e67b0e8fc65c

FilePath: tlatools/src/tlc2/tool/StateQueue.java**
```diff
 	catch (Exception e) {
-	  System.err.println(e.getMessage());
+	  ToolIO.err.println(e.getMessage());
```
ProjectName: 22989-tlaplus
CommitID: 20075cb693231847d0cfc5ad9bbf8e722fce5bd5
CommitMsg: ToolIO.err instead of System.err

git-svn-id: svn+ssh://svn.msr-inria.inria.fr/var/lib/svn/repository/tla/trunk/tla2-inria@12874 76a6fc44-f60b-0410-a9a8-e67b0e8fc65c

FilePath: tlatools/src/tlc2/tool/liveness/DiskGraph.java**
```diff
     catch (IOException e) {
-      System.err.println("DiskGraph.toString(): " + e);
+      ToolIO.err.println("DiskGraph.toString(): " + e);
```
ProjectName: 22989-tlaplus
CommitID: 176613bb18db2a99b09db094ecfdd38ebf03bbff
CommitMsg: ToolIO.err instead of System.err

git-svn-id: svn+ssh://svn.msr-inria.inria.fr/var/lib/svn/repository/tla/trunk/tla2-inria@12869 76a6fc44-f60b-0410-a9a8-e67b0e8fc65c

FilePath: tlatools/src/tlc2/tool/TLCConfig.java**
```diff
     for (int i = 0; i < servers.length; i++) {
-      System.out.println(servers[i]);
+        ToolIO.out.println(servers[i]);
```
ProjectName: 22989-tlaplus
CommitID: ce0764ea7d2f7d9d26baada7949fc0226609af5e
CommitMsg: ToolIO.err instead of System.err

git-svn-id: svn+ssh://svn.msr-inria.inria.fr/var/lib/svn/repository/tla/trunk/tla2-inria@12867 76a6fc44-f60b-0410-a9a8-e67b0e8fc65c

FilePath: tlatools/src/tlc2/tool/StatePoolWriter.java**
```diff
       // Assert.printStack(e);
-      System.err.println("Error: when writing the disk (StatePoolWriter.run):\n" +
+      ToolIO.err.println("Error: when writing the disk (StatePoolWriter.run):\n" +
```
ProjectName: 22989-tlaplus
CommitID: ce0764ea7d2f7d9d26baada7949fc0226609af5e
CommitMsg: ToolIO.err instead of System.err

git-svn-id: svn+ssh://svn.msr-inria.inria.fr/var/lib/svn/repository/tla/trunk/tla2-inria@12867 76a6fc44-f60b-0410-a9a8-e67b0e8fc65c

FilePath: tlatools/src/tlc2/tool/StatePoolReader.java**
```diff
       // Assert.printStack(e);
-      System.err.println("Error: when reading the disk (StatePoolReader.run):\n" +
+      ToolIO.err.println("Error: when reading the disk (StatePoolReader.run):\n" +
```
ProjectName: 22989-tlaplus
CommitID: bca2e5891fda94f3ec405a085dbee1fa9739c8ca
CommitMsg: ToolIO.err instead of System.err

git-svn-id: svn+ssh://svn.msr-inria.inria.fr/var/lib/svn/repository/tla/trunk/tla2-inria@12858 76a6fc44-f60b-0410-a9a8-e67b0e8fc65c

FilePath: tlatools/src/tlc2/tool/DiskFPSet.java**
```diff
       String hostname = InetAddress.getLocalHost().getHostName();    
-      System.out.println(hostname + ", work completed. Thank you!");
+      ToolIO.out.println(hostname + ", work completed. Thank you!");
```
ProjectName: 22989-tlaplus
CommitID: 7c7d1e3dcd1865fde697c0286d2742d484605bd5
CommitMsg: ToolIO.err instead of System.err

git-svn-id: svn+ssh://svn.msr-inria.inria.fr/var/lib/svn/repository/tla/trunk/tla2-inria@12857 76a6fc44-f60b-0410-a9a8-e67b0e8fc65c

FilePath: tlatools/src/tlc2/tool/MemFPSet2.java**
```diff
     String hostname = InetAddress.getLocalHost().getHostName();    
-    System.out.println(hostname + ", work completed. Thank you!");
+    ToolIO.out.println(hostname + ", work completed. Thank you!");
```
ProjectName: 22989-tlaplus
CommitID: 7c7d1e3dcd1865fde697c0286d2742d484605bd5
CommitMsg: ToolIO.err instead of System.err

git-svn-id: svn+ssh://svn.msr-inria.inria.fr/var/lib/svn/repository/tla/trunk/tla2-inria@12857 76a6fc44-f60b-0410-a9a8-e67b0e8fc65c

FilePath: tlatools/src/tlc2/tool/MemFPSet1.java**
```diff
     String hostname = InetAddress.getLocalHost().getHostName();    
-    System.out.println(hostname + ", work completed. Thank you!");
+    ToolIO.out.println(hostname + ", work completed. Thank you!");
```
ProjectName: 22989-tlaplus
CommitID: 7c7d1e3dcd1865fde697c0286d2742d484605bd5
CommitMsg: ToolIO.err instead of System.err

git-svn-id: svn+ssh://svn.msr-inria.inria.fr/var/lib/svn/repository/tla/trunk/tla2-inria@12857 76a6fc44-f60b-0410-a9a8-e67b0e8fc65c

FilePath: tlatools/src/tlc2/tool/MemFPSet.java**
```diff
     String hostname = InetAddress.getLocalHost().getHostName();    
-    System.out.println(hostname + ", work completed. Thank you!");
+    ToolIO.out.println(hostname + ", work completed. Thank you!");
```
ProjectName: 22989-tlaplus
CommitID: 983097be5771f11818e5ab86bef140f828d267ee
CommitMsg: ToolIO.err instead of System.err

git-svn-id: svn+ssh://svn.msr-inria.inria.fr/var/lib/svn/repository/tla/trunk/tla2-inria@12856 76a6fc44-f60b-0410-a9a8-e67b0e8fc65c

FilePath: tlatools/src/tlc2/tool/MemFPIntSet.java**
```diff
     String hostname = InetAddress.getLocalHost().getHostName();    
-    System.out.println(hostname + ", work completed. Thank you!");
+    ToolIO.out.println(hostname + ", work completed. Thank you!");
```
ProjectName: 22989-tlaplus
CommitID: 5a19df0a11c4a40c60027d6cb1ea7fec914673d9
CommitMsg: ToolIO.err instead of System.err

git-svn-id: svn+ssh://svn.msr-inria.inria.fr/var/lib/svn/repository/tla/trunk/tla2-inria@12854 76a6fc44-f60b-0410-a9a8-e67b0e8fc65c

FilePath: tlatools/src/tlc2/module/TLC.java**
```diff
   public static Value Print(Value v1, Value v2) {
-    System.err.println(Value.ppr(v1.toString()) + "  " + Value.ppr(v2.toString()));
+    ToolIO.err.println(Value.ppr(v1.toString()) + "  " + Value.ppr(v2.toString()));
```
ProjectName: 22989-tlaplus
CommitID: 5a19df0a11c4a40c60027d6cb1ea7fec914673d9
CommitMsg: ToolIO.err instead of System.err

git-svn-id: svn+ssh://svn.msr-inria.inria.fr/var/lib/svn/repository/tla/trunk/tla2-inria@12854 76a6fc44-f60b-0410-a9a8-e67b0e8fc65c

FilePath: tlatools/src/tlc2/module/TLC.java**
```diff
   public static Value PrintT(Value v1) {
-    System.err.println(Value.ppr(v1.toString()));
+    ToolIO.err.println(Value.ppr(v1.toString()));
```

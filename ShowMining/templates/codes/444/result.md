###  infomation 
method del:
-net.i2p.util.Log.warn()
method add：
+net.i2p.util.Log.info()
###  support count
project count : 1
commit count : 14
###  code
ProjectName: 23730-i2p.i2p
CommitID: e243e0ddbabe3eaa1a864c3137855fd441794de5
CommitMsg: streaming minor tweaks

FilePath: apps/streaming/java/src/net/i2p/client/streaming/impl/ConnectionHandler.java**
```diff
         // if there are more, they won't get a poison packet.
-        if (_log.shouldLog(Log.WARN))
-            _log.warn("setActive(" + active + ") called, previously " + _active, new Exception("I did it"));
+        if (_log.shouldInfo())
+            _log.info("setActive(" + active + ") called, previously " + _active, new Exception("I did it"));
```
ProjectName: 23730-i2p.i2p
CommitID: abcdcf2e8c60752e0ca03816ee337d197f2f147d
CommitMsg: log tweaks (SSU)

FilePath: router/java/src/net/i2p/router/transport/udp/OutboundEstablishState.java**
```diff
         long now = _context.clock().now();
-        if (_log.shouldLog(Log.WARN))
-            _log.warn(toString() + " accelerating SessionRequest by " + (_nextSend - now) + " ms");
+        if (_log.shouldLog(Log.INFO))
+            _log.info(toString() + " accelerating SessionRequest by " + (_nextSend - now) + " ms");
```
ProjectName: 23730-i2p.i2p
CommitID: 1bbb79f5b16fa1fada4a49302597300ed9f09e2f
CommitMsg: log tweaks

FilePath: router/java/src/net/i2p/router/networkdb/kademlia/StoreJob.java**
```diff
             if ( (_sendThrough != null) && (_msgSize > 0) ) {
-                if (_log.shouldLog(Log.WARN))
-                    _log.warn("sent a " + _msgSize + "byte netDb message through tunnel " + _sendThrough + " after " + howLong);
+                if (_log.shouldLog(Log.INFO))
+                    _log.info("sent a " + _msgSize + " byte netDb message through tunnel " + _sendThrough + " after " + howLong);
```
ProjectName: 23730-i2p.i2p
CommitID: 890f40b2ac99ebf2e59c677a6f90dea4248837c9
CommitMsg: more log tweaks

FilePath: apps/i2psnark/java/src/org/klomp/snark/PeerCoordinator.java**
```diff
                       if (skipped)
-                          _log.warn("Partial piece " + pp + " with multiple peers skipped for seeder");
+                          _log.info("Partial piece " + pp + " with multiple peers skipped for seeder");
```
ProjectName: 23730-i2p.i2p
CommitID: 890f40b2ac99ebf2e59c677a6f90dea4248837c9
CommitMsg: more log tweaks

FilePath: apps/i2psnark/java/src/org/klomp/snark/PeerCoordinator.java**
```diff
                       else
-                          _log.warn("Partial piece " + pp + " NOT in wantedPieces??");
+                          _log.info("Partial piece " + pp + " NOT in wantedPieces??");
```
ProjectName: 23730-i2p.i2p
CommitID: 3ac8083faf142a8d90869954c2b92c1168c4ebb5
CommitMsg: log tweaks

FilePath: apps/i2psnark/java/src/org/klomp/snark/PeerCoordinator.java**
```diff
           }
-          if (_log.shouldLog(Log.WARN) && !partialPieces.isEmpty())
-              _log.warn("Peer " + peer + " has none of our partials " + partialPieces);
+          if (_log.shouldLog(Log.INFO) && !partialPieces.isEmpty())
+              _log.info("Peer " + peer + " has none of our partials " + partialPieces);
```
ProjectName: 23730-i2p.i2p
CommitID: 3ac8083faf142a8d90869954c2b92c1168c4ebb5
CommitMsg: log tweaks

FilePath: apps/i2psnark/java/src/org/klomp/snark/dht/KRPC.java**
```diff
                 if (!lookupDest(nInfo)) {
-                    if (_log.shouldLog(Log.WARN))
-                        _log.warn("Dropping repliable query, no dest for " + nInfo);
+                    if (_log.shouldLog(Log.INFO))
+                        _log.info("Dropping repliable query, no dest for " + nInfo);
```
ProjectName: 23730-i2p.i2p
CommitID: 7d902cca1e38268382e174b1f81d117a1fb16c1a
CommitMsg: log tweak

FilePath: router/java/src/net/i2p/router/transport/UPnP.java**
```diff
 		Set<ForwardPort> portsToForwardNow = null;
-		if (_log.shouldLog(Log.WARN))
-			_log.warn("UP&P Forwarding "+ports.size()+" ports...");
+		if (_log.shouldLog(Log.INFO))
+			_log.info("UP&P Forwarding "+ports.size()+" ports...");
```
ProjectName: 23730-i2p.i2p
CommitID: 4346c90aa2a24cfc089cc7083e3d76c587e329b6
CommitMsg: lower log level

FilePath: router/java/src/net/i2p/router/JobQueue.java**
```diff
                                     if (timeToWait > 10*1000 && iter.hasNext()) {
-                                        if (_log.shouldLog(Log.WARN))
-                                            _log.warn("Failsafe re-sort job " + j +
+                                        if (_log.shouldLog(Log.INFO))
+                                            _log.info("Failsafe re-sort job " + j +
```
ProjectName: 23730-i2p.i2p
CommitID: b47deadc97bb47ce50f0db4d318cd5a91c151aee
CommitMsg: log tweak

FilePath: router/java/src/net/i2p/router/networkdb/kademlia/PersistentDataStore.java**
```diff
                         long time = _context.clock().now() - startTime;
-                        if (_log.shouldLog(Log.WARN))
-                            _log.warn("Wrote " + lastCount + " entries to disk in " + time);
+                        if (_log.shouldLog(Log.INFO))
+                            _log.info("Wrote " + lastCount + " entries to disk in " + time);
```
ProjectName: 23730-i2p.i2p
CommitID: b39ba06d92c876806cabb38dce1764bf5c59da21
CommitMsg: log tweak

FilePath: router/java/src/net/i2p/router/tunnel/TunnelDispatcher.java**
```diff
         if (!removed) {
-            if (_log.shouldLog(Log.WARN))
-                _log.warn("Participating tunnel, but no longer listed in participatingConfig? " + cfg);
+            if (_log.shouldLog(Log.INFO))
+                _log.info("Participating tunnel, but no longer listed in participatingConfig? " + cfg);
```
ProjectName: 23730-i2p.i2p
CommitID: d4bf3403e1a07de62c78980289ce84922f67bf3d
CommitMsg: log tweak

FilePath: apps/i2ptunnel/java/src/net/i2p/i2ptunnel/HTTPResponseOutputStream.java**
```diff
             } finally {
-                if (_log.shouldLog(Log.WARN) && (_in != null))
-                    _log.warn("After decompression, written=" + written + 
+                if (_log.shouldLog(Log.INFO) && (_in != null))
+                    _log.info("After decompression, written=" + written + 
```
ProjectName: 23730-i2p.i2p
CommitID: 4fd1800944a93be96a675a77dd6065be6c64fb08
CommitMsg: log tweaks

FilePath: router/java/src/net/i2p/router/transport/udp/PacketHandler.java**
```diff
                     _state = 19;
-                    if (_log.shouldLog(Log.WARN))
-                        _log.warn("Failed validation with existing con, trying as new con: " + packet);
+                    if (_log.shouldLog(Log.INFO))
+                        _log.info("Failed validation with existing con, trying as new con: " + packet);
```
ProjectName: 23730-i2p.i2p
CommitID: 4fd1800944a93be96a675a77dd6065be6c64fb08
CommitMsg: log tweaks

FilePath: router/java/src/net/i2p/router/transport/TransportImpl.java**
```diff
             _wasUnreachableEntries.remove(peer);
-        if (_log.shouldLog(Log.WARN))
-            _log.warn(this.getStyle() + " setting wasUnreachable to " + yes + " for " + peer);
+        if (_log.shouldLog(Log.INFO))
+            _log.info(this.getStyle() + " setting wasUnreachable to " + yes + " for " + peer);
```

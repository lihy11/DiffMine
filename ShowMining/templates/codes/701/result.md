###  infomation 
method del:
-net.i2p.util.Log.error()
method add：
+net.i2p.util.Log.shouldLog()
+net.i2p.util.Log.warn()
###  support count
project count : 1
commit count : 11
###  code
ProjectName: 23730-i2p.i2p
CommitID: ac902badcd0516bc76de81729fb6c3bc7bce4d41
CommitMsg: log tweak to hide i2pd badness

FilePath: router/java/src/net/i2p/router/tunnel/pool/BuildHandler.java**
```diff
                 _context.statManager().addRateData("tunnel.rejectHostile", 1);
-                _log.error("Dropping build request with the same previous and next hop");
+                if (_log.shouldLog(Log.WARN))
+                    _log.warn("Dropping build request with the same previous and next hop");
```
ProjectName: 23730-i2p.i2p
CommitID: 4613da093d08315606800b0d6fdaa59c727781ec
CommitMsg: log level tweak, bump for review

FilePath: router/java/src/net/i2p/router/transport/udp/MessageReceiver.java**
```diff
         } catch (Exception e) {
-            _log.error("Error handling a message: " + state, e);
+            // e.g. AIOOBE
+            if (_log.shouldLog(Log.WARN))
+                _log.warn("Error handling a message: " + state, e);
```
ProjectName: 23730-i2p.i2p
CommitID: 39d9a25e194a32704ad798606ae1ed7bdd8983fe
CommitMsg: log tweak

FilePath: core/java/src/net/i2p/client/I2PSessionDemultiplexer.java**
```diff
             } else {
-                _log.error("No listener found for proto: " + proto + " port: " + toport + " msg id: " + msgId +
+                if (_log.shouldLog(Log.WARN))
+                    _log.warn("No listener found for proto: " + proto + " port: " + toport + " msg id: " + msgId +
```
ProjectName: 23730-i2p.i2p
CommitID: 1427c502c0615ad314759f2d473545ccd0b11271
CommitMsg: Reduce log level to warn for normal EofException when generating graphs

FilePath: apps/routerconsole/java/src/net/i2p/router/web/SummaryRenderer.java**
```diff
         } catch (IOException ioe) {
-            _log.error("Error rendering", ioe);
+            // typically org.mortbay.jetty.EofException extends java.io.EOFException
+            if (_log.shouldLog(Log.WARN))
+                _log.warn("Error rendering", ioe);
```
ProjectName: 23730-i2p.i2p
CommitID: 1427c502c0615ad314759f2d473545ccd0b11271
CommitMsg: Reduce log level to warn for normal EofException when generating graphs

FilePath: apps/routerconsole/java/src/net/i2p/router/web/StatSummarizer.java**
```diff
         } catch (IOException ioe) {
-            _log.error("Error rendering", ioe);
+            if (_log.shouldLog(Log.WARN))
+                _log.warn("Error rendering", ioe);
```
ProjectName: 23730-i2p.i2p
CommitID: 02bc228d6fed6359d705eea1fe1b45ad90f7056b
CommitMsg: log tweak

FilePath: router/java/src/net/i2p/router/tunnel/pool/BuildHandler.java**
```diff
                 handleReq(ri, _state, _req, _nextPeer);
-            else
-                _log.error("Deferred successfully, but we couldnt find " + _nextPeer.toBase64() + "?");
+            else if (_log.shouldLog(Log.WARN))
+                _log.warn("Deferred successfully, but we couldnt find " + _nextPeer.toBase64() + "?");
```
ProjectName: 23730-i2p.i2p
CommitID: d957712e889352c979f6533938fd7af4936029ad
CommitMsg: Change a common wtf error to a warn

FilePath: router/java/src/net/i2p/router/tunnel/TunnelDispatcher.java**
```diff
         if (dispatchTime > 1000) {
-            _log.error("wtf, took " + dispatchTime + " to dispatch " + msg + " out " + outboundTunnel + " in " + gw);
+            if (_log.shouldLog(Log.WARN))
+                _log.warn("wtf, took " + dispatchTime + " to dispatch " + msg + " out " + outboundTunnel + " in " + gw);
```
ProjectName: 23730-i2p.i2p
CommitID: 5aa66795d2591cf4d024fbcfdc385e6c53bfd528
CommitMsg: 2006-04-06  jrandom
    * Fixed a typo in the reply cleanup code

FilePath: router/java/src/net/i2p/router/message/GarlicMessageBuilder.java**
```diff
         if (timeFromNow < 1*1000) {
-            log.error("Building a message expiring in " + timeFromNow + "ms: " + config, new Exception("created by"));
+            if (log.shouldLog(Log.WARN))
+                log.warn("Building a message expiring in " + timeFromNow + "ms: " + config, new Exception("created by"));
```
ProjectName: 23730-i2p.i2p
CommitID: c528e4db03aecc6780f8cea9b72cde705c910b75
CommitMsg: * 2005-09-29  0.6.1 released
2005-09-29  jrandom
    * Let syndie users modify their metadata.
    * Reseed the router on startup if there aren't enough peer references
      known locally.  This can be disabled by creating the file .i2pnoreseed
      in your home directory, and the existing detection and reseed handling
      on the web interface is unchanged.

FilePath: router/java/src/net/i2p/router/client/ClientConnectionRunner.java**
```diff
         if (_dead) return;
-        if (_context.router().isAlive()) 
-            _log.error("Stop the I2CP connection!  current leaseSet: " 
-                       + _currentLeaseSet, new Exception("Stop client connection"));
+        if (_context.router().isAlive() && _log.shouldLog(Log.WARN)) 
+            _log.warn("Stop the I2CP connection!  current leaseSet: " 
+                      + _currentLeaseSet, new Exception("Stop client connection"));
```
ProjectName: 23730-i2p.i2p
CommitID: 37d5531737cc2ca5e8ea416f00dfd4bc8edd748e
CommitMsg: logging, including replacing the scary monster with its true self (we had data queued up, but were unable to get an ACK on our last write)

FilePath: apps/ministreaming/java/src/net/i2p/client/streaming/I2PSocketManager.java**
```diff
         } else {
-            _log.error(getName() + ": Null socket with data available");
+            if (_log.shouldLog(Log.WARN))
+                _log.warn(getName() + ": Null socket with data available");
```
ProjectName: 23730-i2p.i2p
CommitID: 7a39d9240c63fdb7678f63bb112fe3eb7f1f61e8
CommitMsg: logging

FilePath: router/java/src/net/i2p/router/client/ClientConnectionRunner.java**
```diff
             if (lag > 300) {
-                _log.error("synchronization on the i2cp message send took too long (" + lag 
-                           + "ms): " + msg, new Exception("I2CP Lag"));
+                if (_log.shouldLog(Log.WARN))
+                    _log.warn("synchronization on the i2cp message send took too long (" + lag 
+                              + "ms): " + msg);
```

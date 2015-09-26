# mOnionO - The mobile Onion Observer #

_mOnionO_ is a mobile _Onionoo_ client which can be used to search and display information about _Tor<sup>TM</sup>_ nodes. The client is based on the _Android<sup>TM</sup>_ platform.  _mOnionO based on API-level 10._

<strong><font size='4'>Request for Test!</font>

<font size='3'><i>An initial test version of</i>mOnionO<i>is available in the <a href='http://code.google.com/p/moniono/downloads/list'>Downloads</a> section. We would like to ask as many of you as possible to download that version and install it on emulators or devices. Please send us your feedback to <a href='mailto:moniono@gmx.net'>moniono@gmx.net</a> no matter how intensively you tested the app! If you found any concrete bugs, please directly report them in the <a href='http://code.google.com/p/moniono/issues/list'>Issues</a> section</i></font></strong>

The following screenshots will give you an impression of the provided functionalities:

<table border='0px'>
<tr valign='top'>
<td valign='top'>
<a href='http://moniono.googlecode.com/svn/screenshots/SearchScreen.png' title='Search Screen'>
<img src='http://moniono.googlecode.com/svn/screenshots/SearchScreen.png' width='200px' />
</a>
</td>
<td valign='top'>
<a href='http://moniono.googlecode.com/svn/screenshots/Flags.png' title='Flags View'>
<img src='http://moniono.googlecode.com/svn/screenshots/Flags.png' width='200px' />
</a>
</td>
<td valign='top'>
<a href='http://moniono.googlecode.com/svn/screenshots/Policy.png' title='Policy View'>
<img src='http://moniono.googlecode.com/svn/screenshots/Policy.png' width='200px' />
</a>
</td>
<td valign='top'>
<a href='http://moniono.googlecode.com/svn/screenshots/History.png' title='History View'>
<img src='http://moniono.googlecode.com/svn/screenshots/History.png' width='200px' />
</a>
</td>
</tr>
</table>


## Next Steps ##
The following list gives an overview of the concretely planned next steps:
  * Execution of test phase
  * Publication of _mOnionO_ in _Android<sup>TM</sup>_ market.


## Future Plans ##
Depending on acceptance and feedback, the following topics might be considered for future releases:
  * Notification Service: Notification on favourite nodes becoming (un)available (up/down).
  * Find my Server: Integration with _Google Maps_.
  * State of the Network: Aggregation of statisics on network level, e.g., number of nodes (up/down).
  * ...

## Onionoo ##
The _Onionoo_ project defines a protocol to request status information about nodes of the _Tor_ network. This information is published through a web server being part of the _Onionoo_ project. Information is distributed via HTTPS.

This project makes use of _Onionoo_ information to allow administrators of _Tor_ nodes or other people being interested in the _Tor_ network to observe information on nodes directly from their mobile device. The core features provided by _mOnionO_ are:
  * Search for relays based on their nicknames, IP addresses, and fingerprints.
  * Search for bridges based on fingerprint hashes.
  * Display all node information being provided by _Onionoo_.
  * Favorite nodes list.
  * History charts of bandwidth information.

The _Onionoo_ project itself makes use of information on nodes being directly obtained from _The Tor Project_. For further information on _Onionoo_ please refer to the project [homepage](http://kloesing.github.com/Onionoo/).



_Tor_ is a [registered trademark](https://www.torproject.org/docs/trademark-faq.html.en)
of _The Tor Project, Inc._, _Android_ is a trademark of _Google Inc._
# User Guide #
The _mOnionO_ app consists of two major parts, namely the _Overview_ and the _Details_. The former part provides overviews of favorite nodes and of search results. The latter part supports the inspection of detailed information on a single node.

On starting _mOnionO_ the _Overview_ part is opened.

## Overview ##
On opening the _Overview_ of _mOnionO_, the list of favorite nodes is shown. Initially, this list is empty:
<p>
<img src='http://moniono.googlecode.com/svn/screenshots/EmptyStartScreen.png' width='300px' />
</p>

At the top of the screen, four icons support different actions.
<p>
<img src='http://moniono.googlecode.com/svn/screenshots/menu.png' width='300px' />
</p>
  * The _Star_ icon resets the (result) list below the icons to those nodes which are marked as favorites.
  * The _magnifying glass_ can be used to initiate a search for nodes. For further details go to [Search](How2Use#Search.md).
  * The _Relay_ (_Rl_) and _Bridge_ (_Br_) icons can be used to show/hide the corresponding nodes from the result list. The particular nodes are displayed if the blue icon is shown. On clicking an icon it is greyed out indicating that the corresponding nodes are hidden from the list below. A second click on an icon reactivates it.

### Search ###
On clicking the search button the search bar is opened below the icons.
<p>
<img src='http://moniono.googlecode.com/svn/screenshots/SearchBar.png' width='300px' />
</p>
Within the text field the search text can be entered. A search is executed on clicking the magnifier glass icon behind the search text field.

A search is executed based on nicknames, (hashed) fingerprints, and IP addresses. Multiple search terms can be provided delimited by white spaces. A search result must match all search terms provided.

Each matching node is displayed as an entry in the node list.

<p>
<img src='http://moniono.googlecode.com/svn/screenshots/NodeListEntry.png' width='300px' />
</p>

The icon on the left indicates the type of the node. For these purposes, the same icons as in the header are used. In the example above, a relay node is given. The upper line besides the type icon is used to display the nickname of the particular node. An optional <img src='http://moniono.googlecode.com/svn/screenshots/bookmark.png' height='12px' /> behind the nickname is used to highlight that the corresponding node is already marked as favorite. The nickname is left empty if the node is bridge. The lower line contains the fingerprint of a relay or the hashed fingerprint of a bridge. A green text color means that the node is marked as running while a red text color is used for offline nodes. The online state of nodes is directly derived from data received from _Onionoo_.

Each entry of a favorites- or search results list refers to the details view of the corresponding node (see [Details](How2Use#Details.md). The view can be opened through clicking the list entry.

## Details ##

The details view of a single node consists of four different tabs, namely the _Common_-, _Flags_-, _Policy_-, and _History_ tab:
<p>
<img src='http://moniono.googlecode.com/svn/screenshots/Tabs.png' width='300px' />
</p>

### Common Tab ###
The following  screenshot shows an exemplary _Common_ tab:
<p>
<img src='http://moniono.googlecode.com/svn/screenshots/CommonDetails.png' width='300px' />
</p>

_Onionoo_ information about the current node is shown at the lower part of the tab. As in overview lists, the color of the nickname indicates the online state of the node. If the name is shown in green, _Onionoo_ marked the node as _running_. Otherwise, the nickname is shown in red.

The <img src='http://moniono.googlecode.com/svn/screenshots/bookmark_inactive.png' height='12px' /> icon above the details information indicates that the node is not marked as favorite yet. On clicking the icon, the node is marked as favorite. For this case, the icon switches to <img src='http://moniono.googlecode.com/svn/screenshots/bookmark.png' height='12px' />.

For favorite nodes, additional icons are displayed to perform more actions.
<p>
<img src='http://moniono.googlecode.com/svn/screenshots/favoriteActions.png' width='300px' />
</p>

  1. On clicking the <img src='http://moniono.googlecode.com/svn/screenshots/bookmark.png' height='12px' /> icon, the node is removed from the set of favorite nodes.
  1. On clicking the <img src='http://moniono.googlecode.com/svn/screenshots/edit.png' height='12px' /> icon, the nickname of the node as used by _mOnionO_ can be changed. This can, e.g., be used to name bridges or to better distinguish nodes in the favorites list.
  1. On clicking the <img src='http://moniono.googlecode.com/svn/screenshots/save.png' height='12px' /> icon, a nickname change can be confirmed. _**A nickname change will not affect the original node in any way.**_
  1. On clicking the <img src='http://moniono.googlecode.com/svn/screenshots/refresh.png' height='12px' /> icon, the nickname is reset to the name provided by _Onionoo_.


### Flags Tab ###
The flags tab shows a list of all flags of the current node.

<p>
<img src='http://moniono.googlecode.com/svn/screenshots/Flags.png' width='300px' />
</p>


### Policy Tab ###

The policy tab shows a list of all entries of the node policy.

<p>
<img src='http://moniono.googlecode.com/svn/screenshots/Policy.png' width='300px' />
</p>

### History Tab ###

The history tab shows charts for bandwidth histories provided by _Onionoo_.

<p>
<img src='http://moniono.googlecode.com/svn/screenshots/History.png' width='300px' />
</p>

The drop-down menu below the tabs can be used to select an interval for which a chart should be shown.

<p>
<img src='http://moniono.googlecode.com/svn/screenshots/DropDownSelectHistory.png' width='300px' />
</p>

The provided history intervals depend on the data provided by _Onionoo_.

**_Have fun with_mOnionO_. .._**
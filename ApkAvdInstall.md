_**Notes**_:
  * Please follow this instruction only if you are absolutely know what you are doing. You execute all steps at your own risk!

# Installation of SDK #
If you did not already install the _Android SDK_ onto your PC, notebook etc., you can download it from [here](http://developer.android.com/sdk/index.html). Afterwards, you should follow the instructions at [this page](http://developer.android.com/sdk/installing.html) to install the SDK. Please make sure that you install at least support for API-level 10 as this is the target platform for _mOnionO_.

# Creation of Android Virtual Device #
You should execute the following steps in order to configure an _Android Virtual Device (AVD)_ with support for API-level 10:
  1. Switch to the installation directory of the _Android SDK_
  1. Execute _AVD Manager_
  1. Select _New …_
  1. Configure AVD according to your needs. It is recommended to increase available _Device ram size_ to at least 512 and _Max VM application heap size_ to 64. If you would like to download the _apk_ file directly to the AVD add _SD Card support_ property and set it to _yes_.

# Installation of _mOnionO_ into AVD #
As basic preparation for the original installation you should start the AVD by selecting it in the _AVD Manager_ and clicking _Start …_

If you would like to download and install a _mOnionO apk_ file directly through the AVD, follow the steps described [here](ApkInstallation.md).

Otherwise, execute the following steps to install a _mOnionO_ _apk_ file into your AVD by making use of the _adb_ tool which is provided as part of the _Android SDK_:
  1. Download the desired _apk_ archive from the [download section](http://code.google.com/p/moniono/downloads/list) of the _mOnionO_ project onto your PC, notebook etc.
  1. Switch the directory _platform-tools_ inside the _Android SDK_ installation directory
  1. Execute _adb install_ followed by the fully qualified path to the _apk_ file. For the following example it is assumed that you downloaded the file _mOnionO-0.0.1alpha.apk_ into the directory _c:\temp_ ==> **_adb install c:\temp\ mOnionO-0.0.1alpha.apk_**
  1. Switch to the AVD
  1. Open applications
  1. Execute _mOnionO_
  1. Have fun …

_Android_ is a trademark of _Google Inc._, _Galaxy S2_ is a trademark of _Samsung_
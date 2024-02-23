# AutoStartPermissionHelper

AutoStartPermissionHelper is a handy Android library developed by Abrar Hussain Beigh (aka Koshur Boii), designed to simplify the process of checking for and requesting auto-start permission on various Android devices. With this library, developers can seamlessly integrate auto-start permission handling into their Android applications, ensuring smooth user experiences across different device manufacturers.

## Overview

AutoStartPermissionHelper is an Android library that assists in checking for and requesting auto-start permission on various Android devices. It provides a unified interface to handle auto-start permissions across different device manufacturers.

## Features

- Checks if auto-start permission is available on the device.
- Requests auto-start permission if available.
- Supports various device manufacturers including Xiaomi, Asus, Huawei, Samsung, and more.

## Usage

1. **Integrating the Library**: Add the `AutoStartPermissionHelper` class to your Android project.

2. **Checking for Permission**:

   ```java
   AutoStartPermissionHelper autoStartPermissionHelper = AutoStartPermissionHelper.getInstance();
		
   // Check if the auto-start permission is available on the device
   boolean isAutoStartPermissionAvailable = autoStartPermissionHelper.isAutoStartPermissionAvailable(this, false);
   
   // If the permission is available, request it
   if (isAutoStartPermissionAvailable) {
       boolean granted = autoStartPermissionHelper.getAutoStartPermission(this, true, false);
   }


## Install App demo apk
[![Download AutoStartPermissionHelper App demo apk](https://img.shields.io/badge/Download%20MT%20Manager-Click%20%20here%20to%20download-brightgreen?style=for-the-badge&logo=android)](https://t.me/koshurboiiyt)

## Contact and Social Media Accounts
[![TELEGRAM](https://img.shields.io/badge/CONTACT-TELEGRAM-blue?style=for-the-badge&logo=telegram)](https://t.me/koshurboii)

[![INSTAGRAM](https://img.shields.io/badge/CONTACT-INSTAGRAM-darkred?style=for-the-badge&logo=instagram)](https://Instagram.com/koshurboii)


[![YOUTUBE](https://img.shields.io/badge/SUBSCRIBE-YOUTUBE-red?style=for-the-badge&logo=youtube)](https://www.youtube.com/@koshurboii)


[![WhatsApp](https://img.shields.io/badge/CONTACT-WhatsApp-randish?style=for-the-badge&logo=whatsapp)](https://wa.me/+13023645493)
  ## important


## License

[![MIT](https://img.shields.io/badge/License-MIT-red)](https://github.com/koshurboii/AutoStart-Permission-Helper/blob/main/LICENSE) 
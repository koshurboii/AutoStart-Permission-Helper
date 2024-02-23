# AutoStartPermissionHelper

AutoStartPermissionHelper is a handy Android library developed by Abrar Hussain Beigh (aka Koshur Boii) , designed to simplify the process of checking for and requesting auto-start permission on various Android devices. With this library, developers can seamlessly integrate auto-start permission handling into their Android applications, ensuring smooth user experiences across different device manufacturers.

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
   boolean isPermissionAvailable = autoStartPermissionHelper.isAutoStartPermissionAvailable(context, false);

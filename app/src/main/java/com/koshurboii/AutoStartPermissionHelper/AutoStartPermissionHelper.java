package com.koshurboii.AutoStartPermissionHelper;

 
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * AutoStartPermissionHelper - Handles auto-start permissions for various Android devices.
 * @author koshurboii (telegram/Instagram/github : @koshurboii)
 */

public class AutoStartPermissionHelper {

    private static final String BRAND_XIAOMI = "xiaomi";
    private static final String BRAND_XIAOMI_POCO = "poco";
    private static final String BRAND_XIAOMI_REDMI = "redmi";
    private static final String PACKAGE_XIAOMI_MAIN = "com.miui.securitycenter";
    private static final String PACKAGE_XIAOMI_COMPONENT = "com.miui.permcenter.autostart.AutoStartManagementActivity";

    private static final String BRAND_LETV = "letv";
    private static final String PACKAGE_LETV_MAIN = "com.letv.android.letvsafe";
    private static final String PACKAGE_LETV_COMPONENT = "com.letv.android.letvsafe.AutobootManageActivity";

    private static final String BRAND_ASUS = "asus";
    private static final String PACKAGE_ASUS_MAIN = "com.asus.mobilemanager";
    private static final String PACKAGE_ASUS_COMPONENT = "com.asus.mobilemanager.powersaver.PowerSaverSettings";
    private static final String PACKAGE_ASUS_COMPONENT_FALLBACK = "com.asus.mobilemanager.autostart.AutoStartActivity";

    private static final String BRAND_HONOR = "honor";
    private static final String PACKAGE_HONOR_MAIN = "com.huawei.systemmanager";
    private static final String PACKAGE_HONOR_COMPONENT = "com.huawei.systemmanager.optimize.process.ProtectActivity";

    private static final String BRAND_HUAWEI = "huawei";
    private static final String PACKAGE_HUAWEI_MAIN = "com.huawei.systemmanager";
    private static final String PACKAGE_HUAWEI_COMPONENT = "com.huawei.systemmanager.startupmgr.ui.StartupNormalAppListActivity";
    private static final String PACKAGE_HUAWEI_COMPONENT_FALLBACK = "com.huawei.systemmanager.optimize.process.ProtectActivity";

    private static final String BRAND_OPPO = "oppo";
    private static final String PACKAGE_OPPO_MAIN = "com.coloros.safecenter";
    private static final String PACKAGE_OPPO_FALLBACK = "com.oppo.safe";
    private static final String PACKAGE_OPPO_COMPONENT = "com.coloros.safecenter.permission.startup.StartupAppListActivity";
    private static final String PACKAGE_OPPO_COMPONENT_FALLBACK = "com.oppo.safe.permission.startup.StartupAppListActivity";
    private static final String PACKAGE_OPPO_COMPONENT_FALLBACK_A = "com.coloros.safecenter.startupapp.StartupAppListActivity";

    private static final String BRAND_VIVO = "vivo";
    private static final String PACKAGE_VIVO_MAIN = "com.iqoo.secure";
    private static final String PACKAGE_VIVO_FALLBACK = "com.vivo.permissionmanager";
    private static final String PACKAGE_VIVO_COMPONENT = "com.iqoo.secure.ui.phoneoptimize.AddWhiteListActivity";
    private static final String PACKAGE_VIVO_COMPONENT_FALLBACK = "com.vivo.permissionmanager.activity.BgStartUpManagerActivity";
    private static final String PACKAGE_VIVO_COMPONENT_FALLBACK_A = "com.iqoo.secure.ui.phoneoptimize.BgStartUpManager";

    private static final String BRAND_NOKIA = "nokia";
    private static final String PACKAGE_NOKIA_MAIN = "com.evenwell.powersaving.g3";
    private static final String PACKAGE_NOKIA_COMPONENT = "com.evenwell.powersaving.g3.exception.PowerSaverExceptionActivity";

    private static final String BRAND_SAMSUNG = "samsung";
    private static final String PACKAGE_SAMSUNG_MAIN = "com.samsung.android.lool";
    private static final String PACKAGE_SAMSUNG_COMPONENT = "com.samsung.android.sm.ui.battery.BatteryActivity";
    private static final String PACKAGE_SAMSUNG_COMPONENT_2 = "com.samsung.android.sm.battery.ui.usage.CheckableAppListActivity";
    private static final String PACKAGE_SAMSUNG_COMPONENT_3 = "com.samsung.android.sm.battery.ui.BatteryActivity";

    private static final String BRAND_ONE_PLUS = "oneplus";
    private static final String PACKAGE_ONE_PLUS_MAIN = "com.oneplus.security";
    private static final String PACKAGE_ONE_PLUS_COMPONENT = "com.oneplus.security.chainlaunch.view.ChainLaunchAppListActivity";
    private static final String PACKAGE_ONE_PLUS_ACTION = "com.android.settings.action.BACKGROUND_OPTIMIZE";

    private static final List<String> PACKAGES_TO_CHECK_FOR_PERMISSION = new ArrayList<>(Arrays.asList(
            PACKAGE_ASUS_MAIN,
            PACKAGE_XIAOMI_MAIN,
            PACKAGE_LETV_MAIN,
            PACKAGE_HONOR_MAIN,
            PACKAGE_OPPO_MAIN,
            PACKAGE_OPPO_FALLBACK,
            PACKAGE_VIVO_MAIN,
            PACKAGE_VIVO_FALLBACK,
            PACKAGE_NOKIA_MAIN,
            PACKAGE_HUAWEI_MAIN,
            PACKAGE_SAMSUNG_MAIN,
            PACKAGE_ONE_PLUS_MAIN
    ));

    private static AutoStartPermissionHelper instance = new AutoStartPermissionHelper();

    private AutoStartPermissionHelper() {
    }

    public static AutoStartPermissionHelper getInstance() {
        return instance;
    }

    public boolean getAutoStartPermission(Context context, boolean open, boolean newTask) {
        switch (Build.BRAND.toLowerCase()) {
            case BRAND_ASUS:
                return autoStartAsus(context, open, newTask);
            case BRAND_XIAOMI:
            case BRAND_XIAOMI_POCO:
            case BRAND_XIAOMI_REDMI:
                return autoStartXiaomi(context, open, newTask);
            case BRAND_LETV:
                return autoStartLetv(context, open, newTask);
            case BRAND_HONOR:
                return autoStartHonor(context, open, newTask);
            case BRAND_HUAWEI:
                return autoStartHuawei(context, open, newTask);
            case BRAND_OPPO:
                return autoStartOppo(context, open, newTask);
            case BRAND_VIVO:
                return autoStartVivo(context, open, newTask);
            case BRAND_NOKIA:
                return autoStartNokia(context, open, newTask);
            case BRAND_SAMSUNG:
                return autoStartSamsung(context, open, newTask);
            case BRAND_ONE_PLUS:
                return autoStartOnePlus(context, open, newTask);
            default:
                return false;
        }
    }

    public boolean isAutoStartPermissionAvailable(Context context, boolean onlyIfSupported) {
        PackageManager pm = context.getPackageManager();
        List<ApplicationInfo> packages = pm.getInstalledApplications(0);
        for (ApplicationInfo packageInfo : packages) {
            if (PACKAGES_TO_CHECK_FOR_PERMISSION.contains(packageInfo.packageName)
                    && (!onlyIfSupported || getAutoStartPermission(context, false, false))) {
                return true;
            }
        }
        return false;
    }

    private boolean autoStartXiaomi(Context context, boolean open, boolean newTask) {
        return autoStart(context, Arrays.asList(PACKAGE_XIAOMI_MAIN),
                Arrays.asList(getIntent(PACKAGE_XIAOMI_MAIN, PACKAGE_XIAOMI_COMPONENT, newTask)), open);
        // Similar updates for other autoStart() calls...
    }

    private boolean autoStartAsus(Context context, boolean open, boolean newTask) {
        return autoStart(context, Arrays.asList(PACKAGE_ASUS_MAIN),
                Arrays.asList(
                        getIntent(PACKAGE_ASUS_MAIN, PACKAGE_ASUS_COMPONENT, newTask),
                        getIntent(PACKAGE_ASUS_MAIN, PACKAGE_ASUS_COMPONENT_FALLBACK, newTask)
                ), open);
    }

    private boolean autoStartLetv(Context context, boolean open, boolean newTask) {
        return autoStart(context, Arrays.asList(PACKAGE_LETV_MAIN),
                Arrays.asList(getIntent(PACKAGE_LETV_MAIN, PACKAGE_LETV_COMPONENT, newTask)), open);
    }

    private boolean autoStartHonor(Context context, boolean open, boolean newTask) {
        return autoStart(context, Arrays.asList(PACKAGE_HONOR_MAIN),
                Arrays.asList(getIntent(PACKAGE_HONOR_MAIN, PACKAGE_HONOR_COMPONENT, newTask)), open);
    }

    private boolean autoStartHuawei(Context context, boolean open, boolean newTask) {
        return autoStart(context, Arrays.asList(PACKAGE_HUAWEI_MAIN),
                Arrays.asList(
                        getIntent(PACKAGE_HUAWEI_MAIN, PACKAGE_HUAWEI_COMPONENT, newTask),
                        getIntent(PACKAGE_HUAWEI_MAIN, PACKAGE_HUAWEI_COMPONENT_FALLBACK, newTask)
                ), open);
    }

    private boolean autoStartOppo(Context context, boolean open, boolean newTask) {
        return autoStart(context, Arrays.asList(PACKAGE_OPPO_MAIN, PACKAGE_OPPO_FALLBACK),
                Arrays.asList(
                        getIntent(PACKAGE_OPPO_MAIN, PACKAGE_OPPO_COMPONENT, newTask),
                        getIntent(PACKAGE_OPPO_FALLBACK, PACKAGE_OPPO_COMPONENT_FALLBACK, newTask),
                        getIntent(PACKAGE_OPPO_MAIN, PACKAGE_OPPO_COMPONENT_FALLBACK_A, newTask)
                ), open);
    }

    private boolean launchOppoAppInfo(Context context, boolean open, boolean newTask) {
        try {
            Intent i = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
            i.addCategory(Intent.CATEGORY_DEFAULT);
            i.setData(Uri.parse("package:" + context.getPackageName()));
            if (open) {
                context.startActivity(i);
                return true;
            } else {
                return isActivityFound(context, i);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    private boolean autoStartVivo(Context context, boolean open, boolean newTask) {
        return autoStart(context, Arrays.asList(PACKAGE_VIVO_MAIN, PACKAGE_VIVO_FALLBACK),
                Arrays.asList(
                        getIntent(PACKAGE_VIVO_MAIN, PACKAGE_VIVO_COMPONENT, newTask),
                        getIntent(PACKAGE_VIVO_FALLBACK, PACKAGE_VIVO_COMPONENT_FALLBACK, newTask),
                        getIntent(PACKAGE_VIVO_MAIN, PACKAGE_VIVO_COMPONENT_FALLBACK_A, newTask)
                ), open);
    }

    private boolean autoStartNokia(Context context, boolean open, boolean newTask) {
        return autoStart(context, Arrays.asList(PACKAGE_NOKIA_MAIN),
                Arrays.asList(getIntent(PACKAGE_NOKIA_MAIN, PACKAGE_NOKIA_COMPONENT, newTask)), open);
    }

    private boolean autoStartSamsung(Context context, boolean open, boolean newTask) {
        return autoStart(context, Arrays.asList(PACKAGE_SAMSUNG_MAIN),
                Arrays.asList(
                        getIntent(PACKAGE_SAMSUNG_MAIN, PACKAGE_SAMSUNG_COMPONENT, newTask),
                        getIntent(PACKAGE_SAMSUNG_MAIN, PACKAGE_SAMSUNG_COMPONENT_2, newTask),
                        getIntent(PACKAGE_SAMSUNG_MAIN, PACKAGE_SAMSUNG_COMPONENT_3, newTask)
                ), open);
    }

    private boolean autoStartOnePlus(Context context, boolean open, boolean newTask) {
        return autoStart(context, Arrays.asList(PACKAGE_ONE_PLUS_MAIN),
                Arrays.asList(getIntent(PACKAGE_ONE_PLUS_MAIN, PACKAGE_ONE_PLUS_COMPONENT, newTask)), open)
                || autoStartFromAction(context, Arrays.asList(getIntentFromAction(PACKAGE_ONE_PLUS_ACTION, newTask)), open);
    }

    private void startIntent(Context context, Intent intent) throws Exception {
        try {
            context.startActivity(intent);
        } catch (Exception exception) {
            exception.printStackTrace();
            throw exception;
        }
    }

    private boolean isPackageExists(Context context, String targetPackage) {
        PackageManager pm = context.getPackageManager();
        List<ApplicationInfo> packages = pm.getInstalledApplications(0);
        for (ApplicationInfo packageInfo : packages) {
            if (packageInfo.packageName.equals(targetPackage)) {
                return true;
            }
        }
        return false;
    }

    private Intent getIntent(String packageName, String componentName, boolean newTask) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(packageName, componentName));
        if (newTask) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        return intent;
    }

    private Intent getIntentFromAction(String intentAction, boolean newTask) {
        Intent intent = new Intent();
        intent.setAction(intentAction);
        if (newTask) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        return intent;
    }

    private boolean isActivityFound(Context context, Intent intent) {
        return context.getPackageManager().queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY).size() > 0;
    }

    private boolean areActivitiesFound(Context context, List<Intent> intents) {
        for (Intent intent : intents) {
            if (isActivityFound(context, intent)) {
                return true;
            }
        }
        return false;
    }

    private boolean openAutoStartScreen(Context context, List<Intent> intents) {
        for (Intent intent : intents) {
            if (isActivityFound(context, intent)) {
                context.startActivity(intent);
                return true;
            }
        }
        return false;
    }

    private boolean autoStart(Context context, List<String> packages, List<Intent> intents, boolean open) {
        if (packages.stream().anyMatch(packageName -> isPackageExists(context, packageName))) {
            return open ? openAutoStartScreen(context, intents) : areActivitiesFound(context, intents);
        }
        return false;
    }

    private boolean autoStartFromAction(Context context, List<Intent> intents, boolean open) {
        return open ? openAutoStartScreen(context, intents) : areActivitiesFound(context, intents);
    }
}

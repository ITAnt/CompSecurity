// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.qihoo.security.quc;


public class AccountLog
{
    public static final class FUNC_DATA_LIST extends Enum
    {

        public static final FUNC_DATA_LIST DATA_APP_MGR_UNINSTALL_NUM;
        public static final FUNC_DATA_LIST DATA_BACKUP_APP_SUCCESS_NUM;
        public static final FUNC_DATA_LIST DATA_BLOCKED_SMS_COUNT;
        public static final FUNC_DATA_LIST DATA_BLOCK_BLACKLIST_COUNT;
        public static final FUNC_DATA_LIST DATA_BLOCK_TELEPHONE_NUMBER_COUNT;
        public static final FUNC_DATA_LIST DATA_CHECKUP_CALENDAR;
        public static final FUNC_DATA_LIST DATA_CLEANUP;
        public static final FUNC_DATA_LIST DATA_CLEAN_TOTAL_SIZE;
        public static final FUNC_DATA_LIST DATA_FIND_MALWARE_COUNT;
        public static final FUNC_DATA_LIST DATA_FLOAT_VIEW_CLEANUP;
        public static final FUNC_DATA_LIST DATA_FLOAT_VIEW_SWITCHER;
        public static final FUNC_DATA_LIST DATA_FLOAT_WINDOW_USEED_NUM;
        public static final FUNC_DATA_LIST DATA_KILL_MALWARE_COUNT;
        public static final FUNC_DATA_LIST DATA_NOTIFICATION_TOOLS;
        public static final FUNC_DATA_LIST DATA_SHAKE_HIGHEST_SCORE;
        public static final FUNC_DATA_LIST DATA_SHARE_COUNT;
        private static final FUNC_DATA_LIST a[];
        public final int value;

        public static FUNC_DATA_LIST valueOf(String s)
        {
            return (FUNC_DATA_LIST)Enum.valueOf(com/qihoo/security/quc/AccountLog$FUNC_DATA_LIST, s);
        }

        public static FUNC_DATA_LIST[] values()
        {
            return (FUNC_DATA_LIST[])a.clone();
        }

        static 
        {
            DATA_CLEANUP = new FUNC_DATA_LIST("DATA_CLEANUP", 0, 8001);
            DATA_FIND_MALWARE_COUNT = new FUNC_DATA_LIST("DATA_FIND_MALWARE_COUNT", 1, 8002);
            DATA_KILL_MALWARE_COUNT = new FUNC_DATA_LIST("DATA_KILL_MALWARE_COUNT", 2, 8003);
            DATA_BLOCK_TELEPHONE_NUMBER_COUNT = new FUNC_DATA_LIST("DATA_BLOCK_TELEPHONE_NUMBER_COUNT", 3, 8004);
            DATA_FLOAT_VIEW_CLEANUP = new FUNC_DATA_LIST("DATA_FLOAT_VIEW_CLEANUP", 4, 8005);
            DATA_FLOAT_VIEW_SWITCHER = new FUNC_DATA_LIST("DATA_FLOAT_VIEW_SWITCHER", 5, 8006);
            DATA_NOTIFICATION_TOOLS = new FUNC_DATA_LIST("DATA_NOTIFICATION_TOOLS", 6, 8007);
            DATA_BLOCK_BLACKLIST_COUNT = new FUNC_DATA_LIST("DATA_BLOCK_BLACKLIST_COUNT", 7, 8008);
            DATA_BLOCKED_SMS_COUNT = new FUNC_DATA_LIST("DATA_BLOCKED_SMS_COUNT", 8, 8009);
            DATA_SHAKE_HIGHEST_SCORE = new FUNC_DATA_LIST("DATA_SHAKE_HIGHEST_SCORE", 9, 8010);
            DATA_CLEAN_TOTAL_SIZE = new FUNC_DATA_LIST("DATA_CLEAN_TOTAL_SIZE", 10, 8011);
            DATA_BACKUP_APP_SUCCESS_NUM = new FUNC_DATA_LIST("DATA_BACKUP_APP_SUCCESS_NUM", 11, 8012);
            DATA_APP_MGR_UNINSTALL_NUM = new FUNC_DATA_LIST("DATA_APP_MGR_UNINSTALL_NUM", 12, 8013);
            DATA_CHECKUP_CALENDAR = new FUNC_DATA_LIST("DATA_CHECKUP_CALENDAR", 13, 8014);
            DATA_SHARE_COUNT = new FUNC_DATA_LIST("DATA_SHARE_COUNT", 14, 8015);
            DATA_FLOAT_WINDOW_USEED_NUM = new FUNC_DATA_LIST("DATA_FLOAT_WINDOW_USEED_NUM", 15, 8016);
            a = (new FUNC_DATA_LIST[] {
                DATA_CLEANUP, DATA_FIND_MALWARE_COUNT, DATA_KILL_MALWARE_COUNT, DATA_BLOCK_TELEPHONE_NUMBER_COUNT, DATA_FLOAT_VIEW_CLEANUP, DATA_FLOAT_VIEW_SWITCHER, DATA_NOTIFICATION_TOOLS, DATA_BLOCK_BLACKLIST_COUNT, DATA_BLOCKED_SMS_COUNT, DATA_SHAKE_HIGHEST_SCORE, 
                DATA_CLEAN_TOTAL_SIZE, DATA_BACKUP_APP_SUCCESS_NUM, DATA_APP_MGR_UNINSTALL_NUM, DATA_CHECKUP_CALENDAR, DATA_SHARE_COUNT, DATA_FLOAT_WINDOW_USEED_NUM
            });
        }

        private FUNC_DATA_LIST(String s, int i, int j)
        {
            super(s, i);
            value = j;
        }
    }

    public static final class FUNC_LIST extends Enum
    {

        public static final FUNC_LIST FUNC_ADD_TO_IGNORE_LIST;
        public static final FUNC_LIST FUNC_BACKUP_APK_SUCCESS;
        public static final FUNC_LIST FUNC_BLOCKED_SMS;
        public static final FUNC_LIST FUNC_BLOCK_BLACKLIST;
        public static final FUNC_LIST FUNC_BLOCK_BLACKLIST_BYHAND_SUC;
        public static final FUNC_LIST FUNC_BLOCK_BLACKLIST_CALLLOG_SUC;
        public static final FUNC_LIST FUNC_BLOCK_BLACKLIST_CONTACT_SUC;
        public static final FUNC_LIST FUNC_BLOCK_CALL_RECORD_CLEAN;
        public static final FUNC_LIST FUNC_BLOCK_INCOMING;
        public static final FUNC_LIST FUNC_BLOCK_SMS_RECORD_CLEAN;
        public static final FUNC_LIST FUNC_CHECKUP_BOTTOM_CLEAR_BTN;
        public static final FUNC_LIST FUNC_CHECKUP_CENTER_BTN;
        public static final FUNC_LIST FUNC_CHECKUP_GUIDE_ANTI_THIEF;
        public static final FUNC_LIST FUNC_CHECKUP_GUIDE_APPBOX;
        public static final FUNC_LIST FUNC_CHECKUP_GUIDE_NET_TRAFFIC;
        public static final FUNC_LIST FUNC_CHECKUP_GUIDE_POWER_PROTECTION;
        public static final FUNC_LIST FUNC_CHECK_UPDATE_MANUAL;
        public static final FUNC_LIST FUNC_CLEANUP_ALL;
        public static final FUNC_LIST FUNC_CLEAN_ALL_APK;
        public static final FUNC_LIST FUNC_CLEAN_ALL_FILE;
        public static final FUNC_LIST FUNC_CLEAN_ALL_MAIN;
        public static final FUNC_LIST FUNC_CLEAN_APK_SWIPE;
        public static final FUNC_LIST FUNC_CLEAN_FILE_SWIPE;
        public static final FUNC_LIST FUNC_CLEAR_UNINSTALL_RESIDUAL;
        public static final FUNC_LIST FUNC_CLOUD_SCAN_SUC;
        public static final FUNC_LIST FUNC_DELETE_APK_INSTALLED_SUCCESS;
        public static final FUNC_LIST FUNC_DELETE_APK_NOT_INSTALLED_SUCCESS;
        public static final FUNC_LIST FUNC_EXPORT_CONTACT_SUCCESS;
        public static final FUNC_LIST FUNC_FIX_ALL;
        public static final FUNC_LIST FUNC_FLOAT_ICON_CLEANUP;
        public static final FUNC_LIST FUNC_FLOAT_ICON_CLEAN_SINGLE_APP;
        public static final FUNC_LIST FUNC_FLOAT_ICON_CLICK;
        public static final FUNC_LIST FUNC_FLOAT_ICON_DROP_CLEAN;
        public static final FUNC_LIST FUNC_FLOAT_ICON_SWITCH;
        public static final FUNC_LIST FUNC_FULL_SCAN;
        public static final FUNC_LIST FUNC_IMPORT_CONTACT_SUCCESS;
        public static final FUNC_LIST FUNC_LANG_DOWNLOAD;
        public static final FUNC_LIST FUNC_MAINSCREEN_APPBOX_ENTER;
        public static final FUNC_LIST FUNC_MONITOR_MALWARE;
        public static final FUNC_LIST FUNC_MOVE_APP_TO_INTERNAL_SUCCESS;
        public static final FUNC_LIST FUNC_MOVE_APP_TO_SD_SUCCESS;
        public static final FUNC_LIST FUNC_NOTIFICATION_ALARM_CLOCK;
        public static final FUNC_LIST FUNC_NOTIFICATION_CLEAR;
        public static final FUNC_LIST FUNC_NOTIFICATION_FLASHLIGHT;
        public static final FUNC_LIST FUNC_NOTIFICATION_TASK;
        public static final FUNC_LIST FUNC_OPEN_PROTECTION_SUCCESS;
        public static final FUNC_LIST FUNC_PRIVACY;
        public static final FUNC_LIST FUNC_PRIVACY_NOTIFY_ENTER;
        public static final FUNC_LIST FUNC_PRIVACY_PATTERN;
        public static final FUNC_LIST FUNC_PRIVACY_TEXT;
        public static final FUNC_LIST FUNC_PRIVACY_UNLOCK;
        public static final FUNC_LIST FUNC_QUICK_SCAN;
        public static final FUNC_LIST FUNC_SHAKE_PHONE;
        public static final FUNC_LIST FUNC_SHARE_CLEAN_UP;
        public static final FUNC_LIST FUNC_SHARE_CLEAR;
        public static final FUNC_LIST FUNC_SHARE_SHAKE_PHONE;
        public static final FUNC_LIST FUNC_SHARE_UNLOCK;
        public static final FUNC_LIST FUNC_SLIP_LEFT_IN_RUNNING_PAGE;
        public static final FUNC_LIST FUNC_SLIP_RIGHT_IN_HISTORY_PAGE;
        public static final FUNC_LIST FUNC_SLIP_RIGHT_IN_RUNNING_PAGE;
        public static final FUNC_LIST FUNC_UNINSTALL_SYSTEM_APP_SUCCESS;
        public static final FUNC_LIST FUNC_UNINSTALL_USER_APP_SUCCESS;
        public static final FUNC_LIST FUNC_WIDGET_ADD;
        public static final FUNC_LIST SETTING_NETTRAFFIC_QUOTA;
        public static final FUNC_LIST UI_ENTER_APK_CLEAR;
        public static final FUNC_LIST UI_ENTER_APPLOCK;
        public static final FUNC_LIST UI_ENTER_APP_DATA;
        public static final FUNC_LIST UI_ENTER_APP_MGR_MAIN;
        public static final FUNC_LIST UI_ENTER_CHECKUP_MALWARE_PAGE;
        public static final FUNC_LIST UI_ENTER_CHECKUP_PROCESS_PAGE;
        public static final FUNC_LIST UI_ENTER_CHECKUP_TRASH_PAGE;
        public static final FUNC_LIST UI_ENTER_CHECKUP_VULNERABILITY_PAGE;
        public static final FUNC_LIST UI_ENTER_CLEANUP_PAGE;
        public static final FUNC_LIST UI_ENTER_CONTACT_BACKUP_MAIN;
        public static final FUNC_LIST UI_ENTER_EXPORT_CONTACT;
        public static final FUNC_LIST UI_ENTER_FILE_CLEAR_MAIN;
        public static final FUNC_LIST UI_ENTER_FIREWALL;
        public static final FUNC_LIST UI_ENTER_HISTORY_PAGE;
        public static final FUNC_LIST UI_ENTER_IGNORE_PAGE;
        public static final FUNC_LIST UI_ENTER_IMPORT_CONTACT;
        public static final FUNC_LIST UI_ENTER_NETTRAFFIC;
        public static final FUNC_LIST UI_ENTER_PRIVACY;
        public static final FUNC_LIST UI_ENTER_PRIVATESPACE;
        public static final FUNC_LIST UI_ENTER_PROTECTION;
        public static final FUNC_LIST UI_ENTER_RUNNING_APP_PAGE;
        public static final FUNC_LIST UI_ENTER_SETTING;
        public static final FUNC_LIST UI_FEEDBACK;
        public static final FUNC_LIST UI_OPEN_SIDE_BAR;
        public static final FUNC_LIST UI_RATE;
        public static final FUNC_LIST UI_SHARE;
        private static final FUNC_LIST a[];
        public final int value;

        public static FUNC_LIST valueOf(String s)
        {
            return (FUNC_LIST)Enum.valueOf(com/qihoo/security/quc/AccountLog$FUNC_LIST, s);
        }

        public static FUNC_LIST[] values()
        {
            return (FUNC_LIST[])a.clone();
        }

        static 
        {
            UI_OPEN_SIDE_BAR = new FUNC_LIST("UI_OPEN_SIDE_BAR", 0, 1002);
            UI_FEEDBACK = new FUNC_LIST("UI_FEEDBACK", 1, 1003);
            UI_SHARE = new FUNC_LIST("UI_SHARE", 2, 1004);
            UI_ENTER_SETTING = new FUNC_LIST("UI_ENTER_SETTING", 3, 1005);
            UI_RATE = new FUNC_LIST("UI_RATE", 4, 1006);
            UI_ENTER_CLEANUP_PAGE = new FUNC_LIST("UI_ENTER_CLEANUP_PAGE", 5, 1101);
            UI_ENTER_RUNNING_APP_PAGE = new FUNC_LIST("UI_ENTER_RUNNING_APP_PAGE", 6, 1102);
            UI_ENTER_IGNORE_PAGE = new FUNC_LIST("UI_ENTER_IGNORE_PAGE", 7, 1103);
            UI_ENTER_HISTORY_PAGE = new FUNC_LIST("UI_ENTER_HISTORY_PAGE", 8, 1104);
            UI_ENTER_FILE_CLEAR_MAIN = new FUNC_LIST("UI_ENTER_FILE_CLEAR_MAIN", 9, 1105);
            UI_ENTER_APK_CLEAR = new FUNC_LIST("UI_ENTER_APK_CLEAR", 10, 1108);
            UI_ENTER_APP_MGR_MAIN = new FUNC_LIST("UI_ENTER_APP_MGR_MAIN", 11, 1110);
            UI_ENTER_CONTACT_BACKUP_MAIN = new FUNC_LIST("UI_ENTER_CONTACT_BACKUP_MAIN", 12, 1111);
            UI_ENTER_EXPORT_CONTACT = new FUNC_LIST("UI_ENTER_EXPORT_CONTACT", 13, 1115);
            UI_ENTER_IMPORT_CONTACT = new FUNC_LIST("UI_ENTER_IMPORT_CONTACT", 14, 1116);
            UI_ENTER_PROTECTION = new FUNC_LIST("UI_ENTER_PROTECTION", 15, 1117);
            UI_ENTER_NETTRAFFIC = new FUNC_LIST("UI_ENTER_NETTRAFFIC", 16, 1118);
            UI_ENTER_FIREWALL = new FUNC_LIST("UI_ENTER_FIREWALL", 17, 1119);
            UI_ENTER_APP_DATA = new FUNC_LIST("UI_ENTER_APP_DATA", 18, 1120);
            UI_ENTER_PRIVACY = new FUNC_LIST("UI_ENTER_PRIVACY", 19, 1122);
            UI_ENTER_PRIVATESPACE = new FUNC_LIST("UI_ENTER_PRIVATESPACE", 20, 1123);
            UI_ENTER_APPLOCK = new FUNC_LIST("UI_ENTER_APPLOCK", 21, 1124);
            UI_ENTER_CHECKUP_MALWARE_PAGE = new FUNC_LIST("UI_ENTER_CHECKUP_MALWARE_PAGE", 22, 1125);
            UI_ENTER_CHECKUP_VULNERABILITY_PAGE = new FUNC_LIST("UI_ENTER_CHECKUP_VULNERABILITY_PAGE", 23, 1126);
            UI_ENTER_CHECKUP_TRASH_PAGE = new FUNC_LIST("UI_ENTER_CHECKUP_TRASH_PAGE", 24, 1127);
            UI_ENTER_CHECKUP_PROCESS_PAGE = new FUNC_LIST("UI_ENTER_CHECKUP_PROCESS_PAGE", 25, 1128);
            FUNC_CHECK_UPDATE_MANUAL = new FUNC_LIST("FUNC_CHECK_UPDATE_MANUAL", 26, 3002);
            FUNC_NOTIFICATION_CLEAR = new FUNC_LIST("FUNC_NOTIFICATION_CLEAR", 27, 3006);
            FUNC_NOTIFICATION_FLASHLIGHT = new FUNC_LIST("FUNC_NOTIFICATION_FLASHLIGHT", 28, 3007);
            FUNC_NOTIFICATION_TASK = new FUNC_LIST("FUNC_NOTIFICATION_TASK", 29, 3008);
            FUNC_NOTIFICATION_ALARM_CLOCK = new FUNC_LIST("FUNC_NOTIFICATION_ALARM_CLOCK", 30, 3009);
            FUNC_LANG_DOWNLOAD = new FUNC_LIST("FUNC_LANG_DOWNLOAD", 31, 3010);
            FUNC_FULL_SCAN = new FUNC_LIST("FUNC_FULL_SCAN", 32, 3101);
            FUNC_QUICK_SCAN = new FUNC_LIST("FUNC_QUICK_SCAN", 33, 3102);
            FUNC_FIX_ALL = new FUNC_LIST("FUNC_FIX_ALL", 34, 3103);
            FUNC_MONITOR_MALWARE = new FUNC_LIST("FUNC_MONITOR_MALWARE", 35, 3108);
            FUNC_CLOUD_SCAN_SUC = new FUNC_LIST("FUNC_CLOUD_SCAN_SUC", 36, 3109);
            FUNC_PRIVACY = new FUNC_LIST("FUNC_PRIVACY", 37, 3201);
            FUNC_CLEANUP_ALL = new FUNC_LIST("FUNC_CLEANUP_ALL", 38, 3301);
            FUNC_SLIP_LEFT_IN_RUNNING_PAGE = new FUNC_LIST("FUNC_SLIP_LEFT_IN_RUNNING_PAGE", 39, 3303);
            FUNC_SLIP_RIGHT_IN_RUNNING_PAGE = new FUNC_LIST("FUNC_SLIP_RIGHT_IN_RUNNING_PAGE", 40, 3304);
            FUNC_ADD_TO_IGNORE_LIST = new FUNC_LIST("FUNC_ADD_TO_IGNORE_LIST", 41, 3305);
            FUNC_SLIP_RIGHT_IN_HISTORY_PAGE = new FUNC_LIST("FUNC_SLIP_RIGHT_IN_HISTORY_PAGE", 42, 3306);
            FUNC_CLEAN_ALL_MAIN = new FUNC_LIST("FUNC_CLEAN_ALL_MAIN", 43, 3308);
            FUNC_CLEAN_ALL_FILE = new FUNC_LIST("FUNC_CLEAN_ALL_FILE", 44, 3309);
            FUNC_CLEAN_ALL_APK = new FUNC_LIST("FUNC_CLEAN_ALL_APK", 45, 3310);
            FUNC_CLEAN_FILE_SWIPE = new FUNC_LIST("FUNC_CLEAN_FILE_SWIPE", 46, 3311);
            FUNC_CLEAN_APK_SWIPE = new FUNC_LIST("FUNC_CLEAN_APK_SWIPE", 47, 3312);
            FUNC_FLOAT_ICON_CLICK = new FUNC_LIST("FUNC_FLOAT_ICON_CLICK", 48, 3401);
            FUNC_FLOAT_ICON_SWITCH = new FUNC_LIST("FUNC_FLOAT_ICON_SWITCH", 49, 3402);
            FUNC_FLOAT_ICON_CLEANUP = new FUNC_LIST("FUNC_FLOAT_ICON_CLEANUP", 50, 3403);
            FUNC_FLOAT_ICON_CLEAN_SINGLE_APP = new FUNC_LIST("FUNC_FLOAT_ICON_CLEAN_SINGLE_APP", 51, 3404);
            FUNC_FLOAT_ICON_DROP_CLEAN = new FUNC_LIST("FUNC_FLOAT_ICON_DROP_CLEAN", 52, 3406);
            FUNC_SHAKE_PHONE = new FUNC_LIST("FUNC_SHAKE_PHONE", 53, 3501);
            FUNC_PRIVACY_NOTIFY_ENTER = new FUNC_LIST("FUNC_PRIVACY_NOTIFY_ENTER", 54, 3550);
            FUNC_PRIVACY_TEXT = new FUNC_LIST("FUNC_PRIVACY_TEXT", 55, 3551);
            FUNC_PRIVACY_PATTERN = new FUNC_LIST("FUNC_PRIVACY_PATTERN", 56, 3552);
            FUNC_PRIVACY_UNLOCK = new FUNC_LIST("FUNC_PRIVACY_UNLOCK", 57, 3555);
            FUNC_BLOCK_BLACKLIST = new FUNC_LIST("FUNC_BLOCK_BLACKLIST", 58, 3601);
            FUNC_BLOCK_BLACKLIST_CALLLOG_SUC = new FUNC_LIST("FUNC_BLOCK_BLACKLIST_CALLLOG_SUC", 59, 3606);
            FUNC_BLOCK_BLACKLIST_CONTACT_SUC = new FUNC_LIST("FUNC_BLOCK_BLACKLIST_CONTACT_SUC", 60, 3607);
            FUNC_BLOCK_BLACKLIST_BYHAND_SUC = new FUNC_LIST("FUNC_BLOCK_BLACKLIST_BYHAND_SUC", 61, 3608);
            FUNC_BLOCK_INCOMING = new FUNC_LIST("FUNC_BLOCK_INCOMING", 62, 3609);
            FUNC_BLOCK_CALL_RECORD_CLEAN = new FUNC_LIST("FUNC_BLOCK_CALL_RECORD_CLEAN", 63, 3610);
            FUNC_BLOCKED_SMS = new FUNC_LIST("FUNC_BLOCKED_SMS", 64, 3631);
            FUNC_BLOCK_SMS_RECORD_CLEAN = new FUNC_LIST("FUNC_BLOCK_SMS_RECORD_CLEAN", 65, 3632);
            FUNC_WIDGET_ADD = new FUNC_LIST("FUNC_WIDGET_ADD", 66, 3800);
            FUNC_BACKUP_APK_SUCCESS = new FUNC_LIST("FUNC_BACKUP_APK_SUCCESS", 67, 3854);
            FUNC_UNINSTALL_USER_APP_SUCCESS = new FUNC_LIST("FUNC_UNINSTALL_USER_APP_SUCCESS", 68, 3855);
            FUNC_UNINSTALL_SYSTEM_APP_SUCCESS = new FUNC_LIST("FUNC_UNINSTALL_SYSTEM_APP_SUCCESS", 69, 3856);
            FUNC_DELETE_APK_INSTALLED_SUCCESS = new FUNC_LIST("FUNC_DELETE_APK_INSTALLED_SUCCESS", 70, 3857);
            FUNC_DELETE_APK_NOT_INSTALLED_SUCCESS = new FUNC_LIST("FUNC_DELETE_APK_NOT_INSTALLED_SUCCESS", 71, 3858);
            FUNC_MOVE_APP_TO_SD_SUCCESS = new FUNC_LIST("FUNC_MOVE_APP_TO_SD_SUCCESS", 72, 3859);
            FUNC_MOVE_APP_TO_INTERNAL_SUCCESS = new FUNC_LIST("FUNC_MOVE_APP_TO_INTERNAL_SUCCESS", 73, 3860);
            FUNC_EXPORT_CONTACT_SUCCESS = new FUNC_LIST("FUNC_EXPORT_CONTACT_SUCCESS", 74, 3901);
            FUNC_IMPORT_CONTACT_SUCCESS = new FUNC_LIST("FUNC_IMPORT_CONTACT_SUCCESS", 75, 3902);
            FUNC_OPEN_PROTECTION_SUCCESS = new FUNC_LIST("FUNC_OPEN_PROTECTION_SUCCESS", 76, 3904);
            FUNC_MAINSCREEN_APPBOX_ENTER = new FUNC_LIST("FUNC_MAINSCREEN_APPBOX_ENTER", 77, 3951);
            FUNC_CHECKUP_CENTER_BTN = new FUNC_LIST("FUNC_CHECKUP_CENTER_BTN", 78, 3955);
            FUNC_CHECKUP_BOTTOM_CLEAR_BTN = new FUNC_LIST("FUNC_CHECKUP_BOTTOM_CLEAR_BTN", 79, 3956);
            FUNC_CHECKUP_GUIDE_APPBOX = new FUNC_LIST("FUNC_CHECKUP_GUIDE_APPBOX", 80, 3957);
            FUNC_CHECKUP_GUIDE_ANTI_THIEF = new FUNC_LIST("FUNC_CHECKUP_GUIDE_ANTI_THIEF", 81, 3958);
            FUNC_CHECKUP_GUIDE_NET_TRAFFIC = new FUNC_LIST("FUNC_CHECKUP_GUIDE_NET_TRAFFIC", 82, 3959);
            FUNC_CHECKUP_GUIDE_POWER_PROTECTION = new FUNC_LIST("FUNC_CHECKUP_GUIDE_POWER_PROTECTION", 83, 3960);
            FUNC_CLEAR_UNINSTALL_RESIDUAL = new FUNC_LIST("FUNC_CLEAR_UNINSTALL_RESIDUAL", 84, 3965);
            FUNC_SHARE_UNLOCK = new FUNC_LIST("FUNC_SHARE_UNLOCK", 85, 3966);
            FUNC_SHARE_SHAKE_PHONE = new FUNC_LIST("FUNC_SHARE_SHAKE_PHONE", 86, 3967);
            FUNC_SHARE_CLEAR = new FUNC_LIST("FUNC_SHARE_CLEAR", 87, 3968);
            FUNC_SHARE_CLEAN_UP = new FUNC_LIST("FUNC_SHARE_CLEAN_UP", 88, 3980);
            SETTING_NETTRAFFIC_QUOTA = new FUNC_LIST("SETTING_NETTRAFFIC_QUOTA", 89, 5009);
            a = (new FUNC_LIST[] {
                UI_OPEN_SIDE_BAR, UI_FEEDBACK, UI_SHARE, UI_ENTER_SETTING, UI_RATE, UI_ENTER_CLEANUP_PAGE, UI_ENTER_RUNNING_APP_PAGE, UI_ENTER_IGNORE_PAGE, UI_ENTER_HISTORY_PAGE, UI_ENTER_FILE_CLEAR_MAIN, 
                UI_ENTER_APK_CLEAR, UI_ENTER_APP_MGR_MAIN, UI_ENTER_CONTACT_BACKUP_MAIN, UI_ENTER_EXPORT_CONTACT, UI_ENTER_IMPORT_CONTACT, UI_ENTER_PROTECTION, UI_ENTER_NETTRAFFIC, UI_ENTER_FIREWALL, UI_ENTER_APP_DATA, UI_ENTER_PRIVACY, 
                UI_ENTER_PRIVATESPACE, UI_ENTER_APPLOCK, UI_ENTER_CHECKUP_MALWARE_PAGE, UI_ENTER_CHECKUP_VULNERABILITY_PAGE, UI_ENTER_CHECKUP_TRASH_PAGE, UI_ENTER_CHECKUP_PROCESS_PAGE, FUNC_CHECK_UPDATE_MANUAL, FUNC_NOTIFICATION_CLEAR, FUNC_NOTIFICATION_FLASHLIGHT, FUNC_NOTIFICATION_TASK, 
                FUNC_NOTIFICATION_ALARM_CLOCK, FUNC_LANG_DOWNLOAD, FUNC_FULL_SCAN, FUNC_QUICK_SCAN, FUNC_FIX_ALL, FUNC_MONITOR_MALWARE, FUNC_CLOUD_SCAN_SUC, FUNC_PRIVACY, FUNC_CLEANUP_ALL, FUNC_SLIP_LEFT_IN_RUNNING_PAGE, 
                FUNC_SLIP_RIGHT_IN_RUNNING_PAGE, FUNC_ADD_TO_IGNORE_LIST, FUNC_SLIP_RIGHT_IN_HISTORY_PAGE, FUNC_CLEAN_ALL_MAIN, FUNC_CLEAN_ALL_FILE, FUNC_CLEAN_ALL_APK, FUNC_CLEAN_FILE_SWIPE, FUNC_CLEAN_APK_SWIPE, FUNC_FLOAT_ICON_CLICK, FUNC_FLOAT_ICON_SWITCH, 
                FUNC_FLOAT_ICON_CLEANUP, FUNC_FLOAT_ICON_CLEAN_SINGLE_APP, FUNC_FLOAT_ICON_DROP_CLEAN, FUNC_SHAKE_PHONE, FUNC_PRIVACY_NOTIFY_ENTER, FUNC_PRIVACY_TEXT, FUNC_PRIVACY_PATTERN, FUNC_PRIVACY_UNLOCK, FUNC_BLOCK_BLACKLIST, FUNC_BLOCK_BLACKLIST_CALLLOG_SUC, 
                FUNC_BLOCK_BLACKLIST_CONTACT_SUC, FUNC_BLOCK_BLACKLIST_BYHAND_SUC, FUNC_BLOCK_INCOMING, FUNC_BLOCK_CALL_RECORD_CLEAN, FUNC_BLOCKED_SMS, FUNC_BLOCK_SMS_RECORD_CLEAN, FUNC_WIDGET_ADD, FUNC_BACKUP_APK_SUCCESS, FUNC_UNINSTALL_USER_APP_SUCCESS, FUNC_UNINSTALL_SYSTEM_APP_SUCCESS, 
                FUNC_DELETE_APK_INSTALLED_SUCCESS, FUNC_DELETE_APK_NOT_INSTALLED_SUCCESS, FUNC_MOVE_APP_TO_SD_SUCCESS, FUNC_MOVE_APP_TO_INTERNAL_SUCCESS, FUNC_EXPORT_CONTACT_SUCCESS, FUNC_IMPORT_CONTACT_SUCCESS, FUNC_OPEN_PROTECTION_SUCCESS, FUNC_MAINSCREEN_APPBOX_ENTER, FUNC_CHECKUP_CENTER_BTN, FUNC_CHECKUP_BOTTOM_CLEAR_BTN, 
                FUNC_CHECKUP_GUIDE_APPBOX, FUNC_CHECKUP_GUIDE_ANTI_THIEF, FUNC_CHECKUP_GUIDE_NET_TRAFFIC, FUNC_CHECKUP_GUIDE_POWER_PROTECTION, FUNC_CLEAR_UNINSTALL_RESIDUAL, FUNC_SHARE_UNLOCK, FUNC_SHARE_SHAKE_PHONE, FUNC_SHARE_CLEAR, FUNC_SHARE_CLEAN_UP, SETTING_NETTRAFFIC_QUOTA
            });
        }

        private FUNC_LIST(String s, int i, int j)
        {
            super(s, i);
            value = j;
        }
    }


    public static void a(FUNC_LIST func_list)
    {
    }

    public static void b(FUNC_LIST func_list)
    {
    }
}

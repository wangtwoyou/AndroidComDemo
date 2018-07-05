import android.content.Context
import android.content.Intent
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager

class AppUtil(var context:Context) {
    fun getApps():ArrayList<String>{
        val apps :List<ApplicationInfo> = queryFilterAppInfo()
        val appList :ArrayList<String> = ArrayList()
        for (i in apps.indices) {
            val name = apps[i].loadLabel(context.packageManager).toString()
            appList.add("$name:${apps[i].packageName}")
        }
        return appList
    }

    private fun queryFilterAppInfo(): List<ApplicationInfo> {
        //查询所有已经安装的应用程序
        val pm:PackageManager= context.packageManager
        val appInfos = pm.getInstalledApplications(PackageManager.GET_UNINSTALLED_PACKAGES)
        val applicationInfos:ArrayList<ApplicationInfo> = ArrayList()
        // 创建一个类别为CATEGORY_LAUNCHER的该包名的Intent
        val resolveIntent = Intent(Intent.ACTION_MAIN,null)
        resolveIntent.addCategory(Intent.CATEGORY_LAUNCHER)
        
        val resolveinfoList = context.packageManager.queryIntentActivities(resolveIntent,0)
        val allowPackages:ArrayList<String> = ArrayList()

        for (i in resolveinfoList)
            allowPackages.add(i.activityInfo.parentActivityName)

        for (app in appInfos)
            if(!allowPackages.contains(app.packageName))
                applicationInfos.add(app)

        return applicationInfos

    }
}
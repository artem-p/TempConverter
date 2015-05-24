cd ~/developing/build/TempConverter
gradle clean
gradle assembleRelease
emulator -avd Nexus_5_API_21_x86 &     #     c & в конце запустится в новом потоке
sleep 30
adb shell input keyevent 82          #     разблокировка экрана
adb uninstall ru.artempugachev.tempconverter
adb install app/build/outputs/apk/app-release.apk
exit

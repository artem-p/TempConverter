cd ~/developing/build/TempConverter
gradle clean
gradle assembleDebug assembleDebugAndroidTest
emulator -avd Nexus_5_API_21_x86 &     #     c & в конце запустится в новом потоке
sleep 30
adb shell input keyevent 82          #     разблокировка экрана
adb uninstall ru.artempugachev.tempconverter
adb uninstall ru.artempugachev.tempconverter.test
adb install app/build/outputs/apk/app-debug.apk
adb install app/build/outputs/apk/app-debug-androidTest-unaligned.apk
adb shell am instrument -w -e package ru.artempugachev.tempconverter ru.artempugachev.tempconverter.test/android.support.test.runner.AndroidJUnitRunner
adb emu kill
exit

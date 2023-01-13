object Deps {
    const val plugin_gradle = "com.android.tools.build:gradle:${Versions.gradle}"
    const val plugin_kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"

    const val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    const val kotlin_coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"

    const val support_preference = "androidx.preference:preference:${Versions.preference}"
    const val support_coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val support_appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val support_material = "com.google.android.material:material:${Versions.material}"
    const val support_constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"

    const val mmkv_runtime = "com.tencent:mmkv-static:${Versions.mmkv}"

    const val daggerPlugin = "com.google.dagger:hilt-android-gradle-plugin:${Versions.dagger}"
    const val daggerHiltAndroid = "com.google.dagger:hilt-android:${Versions.dagger}"
    const val daggerHiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.dagger}"
    const val hiltCommon = "androidx.hilt:hilt-common:${Versions.hilt}"
    const val hiltViewModel = "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.hilt}"
    const val hiltWorker = "androidx.hilt:hilt-work:${Versions.hilt}"
    const val hiltCompiler = "androidx.hilt:hilt-compiler:${Versions.hilt}"

    const val network_retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val network_retrofitMoshi = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
    const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
    const val okhttpLogInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"

    const val moshi_adapters = "com.squareup.moshi:moshi-adapters:${Versions.moshi}"
    const val moshi = "com.squareup.moshi:moshi:${Versions.moshi}"
    const val moshi_compiler = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshi}"

    const val androidLifecycleKtx = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    const val androidViewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"

    const val navigation = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigation_ui = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    const val navigationSafeArgs = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation}"

    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"

    const val room_runtime = "androidx.room:room-runtime:${Versions.room}"
    const val room_compiler = "androidx.room:room-compiler:${Versions.room}"
    const val room_ktx = "androidx.room:room-ktx:${Versions.room}"

    const val loading = "com.billy.android:gloading:${Versions.loading}"

    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glide_compiler = "com.github.bumptech.glide:compiler:${Versions.glide}"

    const val paging = "androidx.paging:paging-runtime:${Versions.paging}"

    const val runtimeKtx = "androidx.work:work-runtime-ktx:${Versions.work}"
}
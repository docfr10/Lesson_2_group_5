// Ссылки на зависимости, которые будут использованы ТОЛЬКО в модуле app
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

// Настройки проекта
android {
    namespace = "com.example.lesson_2_group_5"
    compileSdk = 35

    // Включение библиотеки viewBinding
    buildFeatures {
        viewBinding = true
    }

    defaultConfig {
        applicationId = "com.example.lesson_2_group_5"
        minSdk = 23
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

// Ссылки на используемые библиотеки
dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("io.github.takahirom.roborazzi")
}

android {
    namespace = "com.cruning.testroborzzi"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.cruning.testroborzzi"
        minSdk = 24
        targetSdk = 33
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
}

dependencies {
    val appcompat_version = "1.6.1"
    implementation("androidx.appcompat:appcompat:$appcompat_version")
    implementation("androidx.test.ext:junit-ktx:1.1.5")
    testImplementation ("org.robolectric:robolectric:4.11.1")
    testImplementation("io.github.takahirom.roborazzi:roborazzi:1.8.0-alpha-5")
    testImplementation("io.github.takahirom.roborazzi:roborazzi-junit-rule:1.8.0-alpha-5")
}

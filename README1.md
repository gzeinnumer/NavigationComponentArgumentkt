# RecyclerviewCountAllValue

```gradle
buildscript {
    ...
    dependencies {

        //todo 0
        classpath "android.arch.navigation:navigation-safe-args-gradle-plugin:1.0.0-alpha01"

    }
}
```

```gradle
//todo 1
apply plugin: 'androidx.navigation.safeargs'

dependencies {

    //todo 1
    implementation 'androidx.navigation:navigation-fragment-ktx:2.3.5'
    implementation 'androidx.navigation:navigation-ui-ktx:2.3.5'

}

```

```kotlin
//todo 2
class MainFragment : Fragment() {
    ...
}
```

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    ...
    tools:context=".MainFragment">

<!--todo 3-->
    <EditText
        android:id="@+id/ed_name"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />

    <Button
        android:id="@+id/btn"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="16dp"
        android:text="Sent To Second" />
</LinearLayout>
```

```kotlin
//todo 4
class DashboardFragment : Fragment() {
    ...
}
```

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    ...
    tools:context=".DashboardFragment">

    <!--todo 5-->
    <TextView
        android:id="@+id/tv_name"
        android:text="tv_name"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content" />
</LinearLayout>
```

- res->navigation->my_nav.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<navigation xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/my_nav"
    app:startDestination="@id/mainFragment">
<!--todo 6-->
    <fragment
        android:id="@+id/mainFragment"
        android:name="com.gzeinnumer.navigationcomponentargumentkt.MainFragment"
        android:label="fragment_main"
        tools:layout="@layout/fragment_main" >
        <action
            android:id="@+id/action_mainFragment_to_dashboardFragment"
            app:destination="@id/dashboardFragment" />
    </fragment>
    <fragment
        android:id="@+id/dashboardFragment"
        android:name="com.gzeinnumer.navigationcomponentargumentkt.DashboardFragment"
        android:label="fragment_dashboard"
        tools:layout="@layout/fragment_dashboard" >
        <argument
            android:name="username"
            app:type="string" />
    </fragment>
</navigation>
```

```kotlin
class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //todo 7
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        view.findViewById<Button>(R.id.btn).setOnClickListener {
            val action = MainFragmentDirections.action_mainFragment_to_dashboardFragment(ed_name.text.toString())
            view.findNavController().navigate(action)
        }
        return view
    }
}
```

```kotlin
class DashboardFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //todo 8
        val view =  inflater.inflate(R.layout.fragment_dashboard, container, false)
        tv_name.text = DashboardFragmentArgs.fromBundle(arguments).username
        return view
    }

}
```

https://medium.com/incwell-innovations/passing-data-in-android-navigation-architecture-component-part-2-5f1ebc466935

---

```
Copyright 2021 M. Fadli Zein
```

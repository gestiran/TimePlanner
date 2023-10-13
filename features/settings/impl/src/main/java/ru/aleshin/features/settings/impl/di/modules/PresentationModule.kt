/*
 * Copyright 2023 Stanislav Aleshin
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ru.aleshin.features.settings.impl.di.modules

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.screen.Screen
import dagger.Binds
import dagger.Module
import ru.aleshin.core.utils.di.FeatureScope
import ru.aleshin.core.utils.di.ScreenModelKey
import ru.aleshin.features.settings.api.navigation.SettingsFeatureStarter
import ru.aleshin.features.settings.impl.navigation.NavigationManager
import ru.aleshin.features.settings.impl.navigation.SettingsFeatureStarterImpl
import ru.aleshin.features.settings.impl.presentation.ui.donate.screenmodel.DonateScreenModel
import ru.aleshin.features.settings.impl.presentation.ui.donate.screenmodel.DonateStateCommunicator
import ru.aleshin.features.settings.impl.presentation.ui.settings.SettingsScreen
import ru.aleshin.features.settings.impl.presentation.ui.settings.managers.BackupManager
import ru.aleshin.features.settings.impl.presentation.ui.settings.screensmodel.DataWorkProcessor
import ru.aleshin.features.settings.impl.presentation.ui.settings.screensmodel.SettingsEffectCommunicator
import ru.aleshin.features.settings.impl.presentation.ui.settings.screensmodel.SettingsScreenModel
import ru.aleshin.features.settings.impl.presentation.ui.settings.screensmodel.SettingsStateCommunicator
import ru.aleshin.features.settings.impl.presentation.ui.settings.screensmodel.SettingsWorkProcessor

/**
 * @author Stanislav Aleshin on 17.02.2023.
 */
@Module
internal interface PresentationModule {

    @Binds
    @FeatureScope
    fun bindSettingsFeatureStarter(starter: SettingsFeatureStarterImpl): SettingsFeatureStarter

    @Binds
    @FeatureScope
    fun bindNavigationManager(manager: NavigationManager.Base): NavigationManager

    @Binds
    @FeatureScope
    fun bindBackupManager(manager: BackupManager.Base): BackupManager

    // Settings

    @Binds
    @FeatureScope
    fun bindSettingsScreen(screen: SettingsScreen): Screen

    @Binds
    @ScreenModelKey(SettingsScreenModel::class)
    fun bindSettingsScreenModel(screenModel: SettingsScreenModel): ScreenModel

    @Binds
    @FeatureScope
    fun bindSettingsStateCommunicator(communicator: SettingsStateCommunicator.Base): SettingsStateCommunicator

    @Binds
    @FeatureScope
    fun bindSettingsEffectCommunicator(communicator: SettingsEffectCommunicator.Base): SettingsEffectCommunicator

    @Binds
    fun bindSettingsWorkProcessor(processor: SettingsWorkProcessor.Base): SettingsWorkProcessor

    @Binds
    fun bindDataWorkProcessor(processor: DataWorkProcessor.Base): DataWorkProcessor

    // Donate

    @Binds
    @ScreenModelKey(DonateScreenModel::class)
    fun bindDonateScreenModel(screenModel: DonateScreenModel): ScreenModel

    @Binds
    fun bindDonateStateCommunicator(communicator: DonateStateCommunicator.Base): DonateStateCommunicator
}

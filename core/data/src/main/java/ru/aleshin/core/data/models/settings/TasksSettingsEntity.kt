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
package ru.aleshin.core.data.models.settings

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author Stanislav Aleshin on 15.09.2023.
 */
@Entity(tableName = "TasksSettings")
data class TasksSettingsEntity(
    @PrimaryKey var id: Int = 0,
    @ColumnInfo("task_view_status") var taskViewStatus: String = "COMPACT",
    @ColumnInfo("task_analytics_range") var taskAnalyticsRange: String = "WEEK",
    @ColumnInfo("calendar_button_behavior") var calendarButtonBehavior: String = "SET_CURRENT_DATE",
    @ColumnInfo("secure_mode") var secureMode: Boolean = false,
)

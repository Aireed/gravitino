/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.gravitino.listener.api.event;

import org.apache.gravitino.NameIdentifier;
import org.apache.gravitino.listener.api.info.ModelInfo;
import org.apache.gravitino.model.ModelChange;

/** Represents an event fired when a model is successfully altered. */
public class AlterModelEvent extends ModelEvent {
  private final ModelInfo updatedModelInfo;
  private final ModelChange[] modelChanges;

  /**
   * Constructs a new {@link AlterModelEvent} instance with specified user, identifier,
   * updatedModelInfo, and modelChanges.
   *
   * @param user The username of the individual responsible for initiating the model alteration.
   * @param identifier The unique identifier of the altered model, serving as a clear reference
   *     point for the model in question.
   * @param updatedModelInfo The post-alteration state of the model.
   * @param modelChanges An array of {@link ModelChange} objects representing the specific changes
   *     applied to the model during the alteration process.
   */
  public AlterModelEvent(
      String user,
      NameIdentifier identifier,
      ModelInfo updatedModelInfo,
      ModelChange[] modelChanges) {
    super(user, identifier);
    this.updatedModelInfo = updatedModelInfo;
    this.modelChanges = modelChanges;
  }

  /**
   * Retrieves the updated state of the model after the successful alteration.
   *
   * @return A {@link ModelInfo} instance encapsulating the details of the altered model.
   */
  public ModelInfo updatedModelInfo() {
    return updatedModelInfo;
  }

  /**
   * Retrieves the specific changes that were made to the model during the alteration process.
   *
   * @return An array of {@link ModelChange} objects detailing each modification applied to the
   *     model.
   */
  public ModelChange[] modelChanges() {
    return modelChanges;
  }

  /**
   * Returns the type of operation.
   *
   * @return the operation type.
   */
  @Override
  public OperationType operationType() {
    return OperationType.ALTER_MODEL;
  }
}

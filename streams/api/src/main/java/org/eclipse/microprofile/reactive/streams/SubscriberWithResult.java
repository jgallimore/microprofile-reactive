/*******************************************************************************
 * Copyright (c) 2018 Contributors to the Eclipse Foundation
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information regarding copyright ownership.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/

package org.eclipse.microprofile.reactive.streams;

import org.reactivestreams.Subscriber;

import java.util.concurrent.CompletionStage;

/**
 * A subscriber with a result.
 * <p>
 * The result is provided through a {@link CompletionStage}, which is redeemed when the subscriber receives a
 * completion or error signal, or otherwise cancels the stream.
 *
 * @param <T> The type of the elements that the subscriber consumes.
 * @param <R> The type of the result that the subscriber emits.
 */
public final class SubscriberWithResult<T, R> {
  private final Subscriber<T> subscriber;
  private final CompletionStage<R> result;

  public SubscriberWithResult(Subscriber<T> subscriber, CompletionStage<R> result) {
    this.subscriber = subscriber;
    this.result = result;
  }

  /**
   * Get the subscriber.
   *
   * @return The subscriber.
   */
  public Subscriber<T> getRsSubscriber() {
    return subscriber;
  }

  /**
   * Get the result.
   *
   * @return The result.
   */
  public CompletionStage<R> getResult() {
    return result;
  }
}

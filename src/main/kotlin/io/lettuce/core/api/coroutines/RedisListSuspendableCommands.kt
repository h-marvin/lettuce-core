/*
 * Copyright 2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

@file:Suppress("unused")

package io.lettuce.core.api.coroutines

import io.lettuce.core.ExperimentalLettuceCoroutinesApi
import io.lettuce.core.KeyValue
import io.lettuce.core.LPosArgs

/**
 * Coroutine executed commands for Lists.
 *
 * @param <K> Key type.
 * @param <V> Value type.
 * @author Mikhael Sokolov
 * @since 6.0
 * @generated by io.lettuce.apigenerator.CreateKotlinCoroutinesApi
 */
@ExperimentalLettuceCoroutinesApi
interface RedisListSuspendableCommands<K : Any, V : Any> {

    /**
     * Remove and get the first element in a list, or block until one is available.
     *
     * @param timeout the timeout in seconds.
     * @param keys the keys.
     * @return KeyValue<K,V> array-reply specifically:
     *
     *        A `null` multi-bulk when no element could be popped and the timeout expired. A two-element multi-bulk with
     *        the first element being the name of the key where an element was popped and the second element being the value of
     *        the popped element.
     */
    suspend fun blpop(timeout: Long, vararg keys: K): KeyValue<K, V>?

    /**
     * Remove and get the last element in a list, or block until one is available.
     *
     * @param timeout the timeout in seconds.
     * @param keys the keys.
     * @return KeyValue<K,V> array-reply specifically:
     *
     *        A `null` multi-bulk when no element could be popped and the timeout expired. A two-element multi-bulk with
     *        the first element being the name of the key where an element was popped and the second element being the value of
     *        the popped element.
     */
    suspend fun brpop(timeout: Long, vararg keys: K): KeyValue<K, V>?

    /**
     * Pop a value from a list, push it to another list and return it; or block until one is available.
     *
     * @param timeout the timeout in seconds.
     * @param source the source key.
     * @param destination the destination type: key.
     * @return V bulk-string-reply the element being popped from `source` and pushed to `destination`. If
     *        `timeout` is reached, a.
     */
    suspend fun brpoplpush(timeout: Long, source: K, destination: K): V?

    /**
     * Get an element from a list by its index.
     *
     * @param key the key.
     * @param index the index type: long.
     * @return V bulk-string-reply the requested element, or `null` when `index` is out of range.
     */
    suspend fun lindex(key: K, index: Long): V?

    /**
     * Insert an element before or after another element in a list.
     *
     * @param key the key.
     * @param before the before.
     * @param pivot the pivot.
     * @param value the value.
     * @return Long integer-reply the length of the list after the insert operation, or `-1` when the value `pivot`
     *        was not found.
     */
    suspend fun linsert(key: K, before: Boolean, pivot: V, value: V): Long?

    /**
     * Get the length of a list.
     *
     * @param key the key.
     * @return Long integer-reply the length of the list at `key`.
     */
    suspend fun llen(key: K): Long?

    /**
     * Remove and get the first element in a list.
     *
     * @param key the key.
     * @return V bulk-string-reply the value of the first element, or `null` when `key` does not exist.
     */
    suspend fun lpop(key: K): V?

    /**
     * Return the index of matching elements inside a Redis list. By default, when no options are given, it will scan the list
     *from head to tail, looking for the first match of "element". If the element is found, its index (the zero-based position
     *in the list) is returned. Otherwise, if no match is found, `null` is returned. The returned elements indexes are
     *always referring to what [#lindex(java.lang.Object, long)] would return. So first element from head is `0`,
     *and so forth.
     *
     * @param key the key.
     * @param value the element to search for.
     * @return V integer-reply representing the matching element, or null if there is no match.
     * @since 5.3.2
     */
    suspend fun lpos(key: K, value: V): Long?

    /**
     * Return the index of matching elements inside a Redis list. By default, when no options are given, it will scan the list
     *from head to tail, looking for the first match of "element". If the element is found, its index (the zero-based position
     *in the list) is returned. Otherwise, if no match is found, `null` is returned. The returned elements indexes are
     *always referring to what [#lindex(java.lang.Object, long)] would return. So first element from head is `0`,
     *and so forth.
     *
     * @param key the key.
     * @param value the element to search for.
     * @param args command arguments to configure`FIRST` and `MAXLEN` options.
     * @return V integer-reply representing the matching element, or null if there is no match.
     * @since 5.3.2
     */
    suspend fun lpos(key: K, value: V, args: LPosArgs): Long?

    /**
     * Return the index of matching elements inside a Redis list using the `COUNT` option. By default, when no options are
     *given, it will scan the list from head to tail, looking for the first match of "element". The returned elements indexes
     *are always referring to what [#lindex(java.lang.Object, long)] would return. So first element from head is
     *`0`, and so forth.
     *
     * @param key the key.
     * @param value the element to search for.
     * @param count limit the number of matches.
     * @return V integer-reply representing the matching elements, or empty if there is no match.
     * @since 5.3.2
     */
    suspend fun lpos(key: K, value: V, count: Int): List<Long>

    /**
     * Return the index of matching elements inside a Redis list using the `COUNT` option. By default, when no options are
     *given, it will scan the list from head to tail, looking for the first match of "element". The returned elements indexes
     *are always referring to what [#lindex(java.lang.Object, long)] would return. So first element from head is
     *`0`, and so forth.
     *
     * @param key the key.
     * @param value the element to search for.
     * @param count limit the number of matches.
     * @param args command arguments to configure`FIRST` and `MAXLEN` options.
     * @return V integer-reply representing the matching elements, or empty if there is no match.
     * @since 5.3.2
     */
    suspend fun lpos(key: K, value: V, count: Int, args: LPosArgs): List<Long>

    /**
     * Prepend one or multiple values to a list.
     *
     * @param key the key.
     * @param values the value.
     * @return Long integer-reply the length of the list after the push operations.
     */
    suspend fun lpush(key: K, vararg values: V): Long?

    /**
     * Prepend values to a list, only if the list exists.
     *
     * @param key the key.
     * @param values the values.
     * @return Long integer-reply the length of the list after the push operation.
     */
    suspend fun lpushx(key: K, vararg values: V): Long?

    /**
     * Get a range of elements from a list.
     *
     * @param key the key.
     * @param start the start type: long.
     * @param stop the stop type: long.
     * @return List<V> array-reply list of elements in the specified range.
     */
    suspend fun lrange(key: K, start: Long, stop: Long): List<V>

    /**
     * Remove elements from a list.
     *
     * @param key the key.
     * @param count the count type: long.
     * @param value the value.
     * @return Long integer-reply the number of removed elements.
     */
    suspend fun lrem(key: K, count: Long, value: V): Long?

    /**
     * Set the value of an element in a list by its index.
     *
     * @param key the key.
     * @param index the index type: long.
     * @param value the value.
     * @return String simple-string-reply.
     */
    suspend fun lset(key: K, index: Long, value: V): String?

    /**
     * Trim a list to the specified range.
     *
     * @param key the key.
     * @param start the start type: long.
     * @param stop the stop type: long.
     * @return String simple-string-reply.
     */
    suspend fun ltrim(key: K, start: Long, stop: Long): String?

    /**
     * Remove and get the last element in a list.
     *
     * @param key the key.
     * @return V bulk-string-reply the value of the last element, or `null` when `key` does not exist.
     */
    suspend fun rpop(key: K): V?

    /**
     * Remove the last element in a list, append it to another list and return it.
     *
     * @param source the source key.
     * @param destination the destination type: key.
     * @return V bulk-string-reply the element being popped and pushed.
     */
    suspend fun rpoplpush(source: K, destination: K): V?

    /**
     * Append one or multiple values to a list.
     *
     * @param key the key.
     * @param values the value.
     * @return Long integer-reply the length of the list after the push operation.
     */
    suspend fun rpush(key: K, vararg values: V): Long?

    /**
     * Append values to a list, only if the list exists.
     *
     * @param key the key.
     * @param values the values.
     * @return Long integer-reply the length of the list after the push operation.
     */
    suspend fun rpushx(key: K, vararg values: V): Long?

}


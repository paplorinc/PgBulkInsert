// Copyright (c) Philipp Wagner. All rights reserved.
// Licensed under the MIT license. See LICENSE file in the project root for full license information.

package de.bytefish.pgbulkinsert.de.bytefish.pgbulkinsert.pgsql.handlers;

import de.bytefish.pgbulkinsert.de.bytefish.pgbulkinsert.pgsql.converter.IValueConverter;
import de.bytefish.pgbulkinsert.de.bytefish.pgbulkinsert.pgsql.converter.LocalDateTimeConverter;

import java.io.DataOutputStream;
import java.time.LocalDateTime;

public class LocalDateTimeHandler extends BaseValueHandler<LocalDateTime> {

    private IValueConverter<LocalDateTime, Long> dateTimeConverter;

    public LocalDateTimeHandler() {
        this(new LocalDateTimeConverter());
    }

    public LocalDateTimeHandler(IValueConverter<LocalDateTime, Long> dateTimeConverter) {

        this.dateTimeConverter = dateTimeConverter;
    }

    @Override
    protected void internalHandle(DataOutputStream buffer, final LocalDateTime value) throws Exception {
        buffer.writeInt(8);
        buffer.writeLong(dateTimeConverter.convert(value));
    }

}

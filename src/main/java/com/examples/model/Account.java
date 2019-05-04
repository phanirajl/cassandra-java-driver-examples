package com.examples.model;

import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.Frozen;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;
import lombok.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Setter
@Table(
        keyspace = "ks", name = "users",
        readConsistency = "LOCAL_ONE",
        writeConsistency = "LOCAL_QUORUM",
        caseSensitiveKeyspace = false,
        caseSensitiveTable = false
)

public class Account {

     @PartitionKey
     @Column(
             name = "account_id"
     )
     private String accountId;
     @Column(
            name="full_name"
     )
     private  String fullName;

     @Column(
            name="address"
     )
     @Frozen
     private List<Address> address;
}

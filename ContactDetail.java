package com.lbg.ep.customer.core.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.lbg.ep.customer.common.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper=false)
@JsonRootName("ContactDetail")
@Table(name = "ContactDetail")
@Entity
public class ContactDetail extends BaseEntity {

//    @PrimaryKey(keyOrder = 1)
    @Column(name = "OrgId")
    private String orgId;

//    @Column(name = "CustomerId")
//    @PrimaryKey(keyOrder = 2)
    private String customerId;

//    @PrimaryKey(keyOrder = 3)
    @Id
    @JsonProperty("ContactDetailId")
    @Column(name = "ContactDetailId")
    private String contactDetailId;

//    @PrimaryKey(keyOrder = 4)
    @Column(name = "BrandId")
    private String brandId;

    @Column(name = "ContactType")
    private Long contactType;

    @JsonProperty("ContactReference")
    @Column(name = "ContactReference")
    private String contactReference;

    @JsonProperty("DialingCode")
    @Column(name = "DialingCode")
    private String dialingCode;

    @JsonProperty("PhoneNumber")
    @Column(name = "PhoneNumber")
    private Long phoneNumber;

    @JsonProperty("PhoneExtNumber")
    @Column(name = "PhoneExtNumber")
    private Long phoneExtNumber;

    @JsonProperty("Status")
    @Column(name = "Status")
    private Long status;

    @ManyToOne
    @JoinColumn(name="CustomerId", nullable=false)
    private Customer customerModel;
}

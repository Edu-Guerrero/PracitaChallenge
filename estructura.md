# Estructura de: Challenge

```
Challenge/
├── .git
│   ├── hooks
│   │   ├── applypatch-msg.sample
│   │   ├── commit-msg.sample
│   │   ├── fsmonitor-watchman.sample
│   │   ├── post-update.sample
│   │   ├── pre-applypatch.sample
│   │   ├── pre-commit.sample
│   │   ├── pre-merge-commit.sample
│   │   ├── pre-push.sample
│   │   ├── pre-rebase.sample
│   │   ├── pre-receive.sample
│   │   ├── prepare-commit-msg.sample
│   │   ├── push-to-checkout.sample
│   │   ├── sendemail-validate.sample
│   │   └── update.sample
│   ├── info
│   │   └── exclude
│   ├── logs
│   │   ├── refs
│   │   │   ├── heads
│   │   │   │   └── main
│   │   │   ├── remotes
│   │   │   │   └── origin
│   │   │   │       └── main
│   │   │   └── stash
│   │   └── HEAD
│   ├── objects
│   │   ├── 00
│   │   │   ├── 6e5373e9150edcef4d36ff57137146644922c7
│   │   │   └── e6dc4bd4304fa9711ccf65dd6aabcb9a1c7007
│   │   ├── 01
│   │   │   ├── 81923af93a0a7af063d0531a7439ffd142c0e8
│   │   │   └── 8ff33a5297bc889d78f33604b265512757136b
│   │   ├── 02
│   │   │   ├── 6c49652c2a03ac840cfa884ec569f7927cf0dd
│   │   │   ├── 8449c852eea2447e0b946af7a6ba3df6450570
│   │   │   ├── 91e3f7543511b30626c714fff860fe8a923030
│   │   │   └── f7052d73c0a9aa35a4fc44a7c7cf577f35b8ff
│   │   ├── 04
│   │   │   ├── 4d5e0c51552b00c04d3201eba4d2ad7c903c68
│   │   │   └── 882a991139b47d86e5ff6033c51df6f31aebc6
│   │   ├── 05
│   │   │   ├── 8c9d300d55702829a07a79e9ad229a737191e9
│   │   │   └── e6a8eb498aeb2676efe15a86e62199c03fc793
│   │   ├── 06
│   │   │   └── b5e55cd77f547733a82aa2ee1eb81298e14d07
│   │   ├── 07
│   │   │   ├── 000dff26dae277a8f08f69a327d037dc0c98fd
│   │   │   ├── 9bc240d0f3cd29c55888953353d7f9598b5836
│   │   │   ├── b55621a4900972a648fdbc94266543c8d91dfd
│   │   │   └── f4758ea34b47236c8f54c267e3b5f6b75ca249
│   │   ├── 08
│   │   │   ├── 289f78124fd456d7707326ab6a4d4004fa4cc1
│   │   │   ├── 81e84b6ecf7903cb13616c49075e87f57ed72a
│   │   │   └── d7a656b9ac6f0024780fdad2c82bc0c26e49f7
│   │   ├── 09
│   │   │   ├── 664f4f37ffd5e38587be69722e4e9d8e6f15fa
│   │   │   ├── 6d57b3fd9f9b6371135b2766e0098d940eeb7d
│   │   │   ├── 7218eb6a4753f58445adbe80101beb11ddf03d
│   │   │   ├── 97a9ee0c153a4acc994378eaa29ea83e7a5dcd
│   │   │   └── c35a42294a238abf91d9ff3575e010be05bcc1
│   │   ├── 0a
│   │   │   ├── 47d5a99743eb2c029a932cf24ded8e3f30538a
│   │   │   └── e4df4b9ce37d03b88f275328ddd694b122a038
│   │   ├── 0c
│   │   │   └── 470172f9e40f0ce534336df58a26981d8bf3e7
│   │   ├── 0d
│   │   │   ├── 49b07f8fd731ef4083e4177efd7cac672e3608
│   │   │   └── ea457a08286b1d0bd1584f1c07bc0f8b3c0969
│   │   ├── 0e
│   │   │   ├── 02084581f3eeca29b248ded00b04f4546d0e01
│   │   │   ├── 76306c74695119b2171d2f2b1a5428b77a8e4b
│   │   │   ├── c3b11e205c77621202b77427382d57fe245b45
│   │   │   └── c3b4cd3d4e73915993313a0cfb68f3832acc9f
│   │   ├── 0f
│   │   │   ├── 075018d1736b79607fd08189743ffcf991b714
│   │   │   └── 1b7c9a94240861c82a592cbd88d8203726b0c5
│   │   ├── 10
│   │   │   └── de6abf2af134436eac2ce732053d09c5b71e7f
│   │   ├── 11
│   │   │   ├── 520afe14640b0f6baef1c15d4caffad42bcafe
│   │   │   └── 76c060174591aa6de643674b6f0ab0aeca8bb2
│   │   ├── 12
│   │   │   ├── 0f0bc03c4d306f391098958e9eab95bb249e3b
│   │   │   ├── 2079ac0ff55df9e035ac701184189964e0bbf5
│   │   │   ├── 9c471ab35a99ecaae5b4929386fa5e48a490b3
│   │   │   ├── b7e97da09bad13922cf29e7cb9f12832755547
│   │   │   ├── c35141fc12f09e3ed216ed497c6a4d701bca36
│   │   │   └── d23b3b27a8b9eddadfb2464a09734ae673e5ce
│   │   ├── 13
│   │   │   ├── 2a15e4a7bfe87dac6f518e00dae5695a5d9cb3
│   │   │   ├── 4b12bf1bfcbff8bac539cb80cc8e64d74cdaef
│   │   │   ├── ace62bd39f414958c76f85e5a39114792f0487
│   │   │   └── db613870518704fe735faec36213ca5c52f0d0
│   │   ├── 14
│   │   │   ├── 8b9e3e282ac747d190a8718764a1137476b798
│   │   │   └── e85f4df6c81e39a8237efdf551c86ae3970791
│   │   ├── 15
│   │   │   ├── c464acbde5bf13c462b849654f60ad48a9db9b
│   │   │   └── c73b45f1db6b8f23f4a1027539b7a34bd355a5
│   │   ├── 16
│   │   │   ├── 296e0e1f96aa58854e2f94171e64d55832aff2
│   │   │   ├── 2edd2b8101ae54dc2be48df5a506efae7ce1b6
│   │   │   └── ae806e12b1ab2e95713074e23b0eabdfeaa8fe
│   │   ├── 17
│   │   │   └── 8769fc25ceea4d242c69ecb862db2f2d0a89d3
│   │   ├── 18
│   │   │   └── 340ea0a84573fef3f784ffe0571d08735ec4dc
│   │   ├── 19
│   │   │   ├── 1e4b397bff4a62d8bd7a6842b0675a361fc4e9
│   │   │   ├── 3917cd0322cbbc69787865fa0102b44c7f4e52
│   │   │   └── c63be158b4fbc28d824265c35a790c58d57c9e
│   │   ├── 1a
│   │   │   ├── 0ec4f7462eb31186abfecc6eb315780e3199fb
│   │   │   ├── 27017423f23d8088f4df0b97371f7e1e629475
│   │   │   ├── 87b27328e172f559b74cfcc9dcfc26d9daa3dc
│   │   │   └── b4f3b8c5cd09f231792473e8126001672204fe
│   │   ├── 1b
│   │   │   ├── 33c55baabb587c669f562ae36f953de2481846
│   │   │   ├── 6ad87f6c09daefa0d9575cf25ee0417e70f87e
│   │   │   └── f0e3d359284c0a51ae3d89c16ecbdbfe70863e
│   │   ├── 1c
│   │   │   ├── 188f8a940c85ef1d040e803cebac8bbc87d06e
│   │   │   ├── 2c6c722f6192225bc31c6686932f59200a9c95
│   │   │   ├── 48706d9488917c529f67754cb79eb214d5a26f
│   │   │   ├── 9aef6da44ab5c01afed3a1c508374c804de939
│   │   │   ├── c4c67fa5f7f9a96c0de166633f721be95cc3da
│   │   │   └── d6effd0955714afa52565bcbe7b8a17c68e0e0
│   │   ├── 1d
│   │   │   ├── 51f66356a43efc4995872d15a8dea50c882132
│   │   │   └── 754bd8cd1d33a69b2282bcce0183b81138d137
│   │   ├── 1e
│   │   │   ├── 82137a143930585bac594b1149ea6812740a76
│   │   │   └── dc63a473295f75bcd3d85fa8878e393d6b9792
│   │   ├── 1f
│   │   │   ├── 027f7d3b23546431e27d398f1c67d8e1584f25
│   │   │   ├── 27d4e07ecbe1f8acbfdd345038208daf6f32c7
│   │   │   ├── 8bb56ca379a8627ff285dad52bb835cf98476d
│   │   │   ├── c6128263403c62edfc1c1a0ddca2f59eb89611
│   │   │   └── fa3170a5e815a6dc1e8cf7638587df9cfe9174
│   │   ├── 20
│   │   │   └── c777d20f7dc0ea70aec44a2dcbb6b2fadb3b0e
│   │   ├── 21
│   │   │   └── 41f87df7242a0badddf07d84a8116dd5e32b34
│   │   ├── 22
│   │   │   └── 35e1b6ed25ea9d7b5b8610d2cefa94c2f4fa98
│   │   ├── 23
│   │   │   ├── 10ce174bf08b69046dbcbe08f6a5b80a427b05
│   │   │   ├── 120a4a4202329974e22f2e8ec5ca55849099ef
│   │   │   ├── 516f18210efbfc5fb2393b72eab719e619be85
│   │   │   ├── 60b41f74f803f33978e9ee6d7684efd741e9da
│   │   │   ├── d15a9367071145e9c79bb4ddf879d1fbe78b5d
│   │   │   └── fcd6ce2d05126b0d3aa3247b5c4453ce1fe55a
│   │   ├── 24
│   │   │   ├── 68663b15dbb75b269a9cd7406fb8ed2269a346
│   │   │   ├── cedbb7d01a73e15806b2572458f7cca710eac8
│   │   │   └── dd79dca7881d7973ad621ef33fb6f580a80ae8
│   │   ├── 25
│   │   │   ├── 7a15e7d77bb175e55e68f7b8f6bc2312f5ff5f
│   │   │   └── 8bd91382ccb7d55a7b7324c9d1b8efb043fedc
│   │   ├── 26
│   │   │   └── 7d1e38f523f89a38d3e026c3f1c2f4f4622173
│   │   ├── 27
│   │   │   ├── be969876bebd893d921730450bcf8ad8f78429
│   │   │   └── d328f1cc935ad2de17613c1b536fd50367d9a0
│   │   ├── 28
│   │   │   └── df278752adab9d9946ea2c6bdd5b987aaea41b
│   │   ├── 29
│   │   │   ├── 0ad0d7503cbc9512c7398441d6e8ab1f2c9fc4
│   │   │   └── ec0015fd473da357bf3dbb79ed0822795405f4
│   │   ├── 2a
│   │   │   └── 3c6ab6bc7bbc6d06efded10fa1145b31c9a191
│   │   ├── 2b
│   │   │   ├── 576be175042a2fe1ff1e21bbc10b570313e8e3
│   │   │   └── a17db0b83313b0062356398ace99b92c338cd2
│   │   ├── 2c
│   │   │   ├── 02e93eddbf562139e6164b5f0bd30284f6e791
│   │   │   ├── 73ebad6cc0644b22eb952592b74834ded6dadd
│   │   │   └── aab33ecd4396b43011e2abc3e45a444d9bb71f
│   │   ├── 2d
│   │   │   ├── 7f44a20f42c5b8ffed432532021d015cd1931a
│   │   │   └── e950644ffd4fe8d621920cbbf2163bcdb94196
│   │   ├── 2e
│   │   │   ├── 1b471e18f71721b6b1091aa0523715a3032a79
│   │   │   ├── 568bb98e412b36ff34ff0522548257c2da5882
│   │   │   └── a7f898b67185bdd0df83742db6f019e820e690
│   │   ├── 2f
│   │   │   ├── 214a72d1bcf4dff4a87279a372f229c432cba7
│   │   │   ├── 70eec9fd3178ffc5f6d5987e4c114957befb26
│   │   │   └── a4e0f090c891f6e2c2b8ba1b18948e496c6d3f
│   │   ├── 30
│   │   │   ├── 1960586fa6917a64ff8833a6bbe98195bbc579
│   │   │   ├── 2fd0df7dd8b5ba7e09e4effceef134480db075
│   │   │   ├── 34dc6f7e3414b8f70827ee667df1fdfa266dd0
│   │   │   ├── 8b94e4dc2c6351768b0e0ff22be917ad3fa045
│   │   │   ├── a24e8260a200f88283b22ac314e8a48ac33968
│   │   │   └── c6c813a4320e68f6bd33ff63dc7ed60bdc0f85
│   │   ├── 31
│   │   │   ├── 137685cbb79dbd45088e3f9e6f5009c4555173
│   │   │   └── 8afde76e62e3b455e8a9bdc8f2766cd0d19cbd
│   │   ├── 32
│   │   │   └── adbbf205c02d41758a44be46ef0bff446bd8a7
│   │   ├── 33
│   │   │   ├── 3d3ce7968e5c2ddaa6fcd69c9e652a3e85ae16
│   │   │   ├── 6805a8acfd9a6df1e2bfcf41eacc30d415f515
│   │   │   └── 7908c98ba147b8f8c8689cc1b0aa71697c3b35
│   │   ├── 34
│   │   │   ├── 0887e4925512511b1dedf2ab23dcf7f21e4c87
│   │   │   ├── 38939003449a43a189dfaade55903787cdbc72
│   │   │   ├── 64864392e56bc91107f7933552624335119063
│   │   │   ├── ce7aa292a665cc270184a313f2ddb0698b11a5
│   │   │   ├── f97e5ac405b9f4c2d86dd347708c2f2f626d93
│   │   │   └── fab0228510c5b363876413ed513b1bd1726a88
│   │   ├── 35
│   │   │   └── e113834afa11146bae834ccf4290d84a8d4a9a
│   │   ├── 36
│   │   │   └── 126df753dd81fc5cf4023a5c816da460efb097
│   │   ├── 37
│   │   │   ├── 56112f916adece84ef70bac38e7b789310e719
│   │   │   ├── 7d54105c7b4e5818b042f5af6618f51f7b2936
│   │   │   ├── 88a6ae86f3963bd4312b0d6602aa7be0207106
│   │   │   └── 8f761038d8311a4824a0a31132979dbac32f0a
│   │   ├── 38
│   │   │   ├── 1f32f6340f52cc060873dadde1842324308222
│   │   │   ├── d4410441c8bb2c0a36a687f323c3e88661f01e
│   │   │   └── fd86fd5593a3b497fc0a58ae1bdf08ee4a2241
│   │   ├── 39
│   │   │   ├── 08c286e14f51b6a0ceb1893d7a7635cf0afa8b
│   │   │   ├── 7529252f84933361ea58be202bfada595dbcc1
│   │   │   └── e8492679cca68f6d9a3d47e7a52c7403a526a7
│   │   ├── 3a
│   │   │   └── 12610f01fe5a41e78b4c7e91e1bd54d35dcc12
│   │   ├── 3b
│   │   │   ├── 0358fa9c3f25b489b74fb8bb017b3861604d03
│   │   │   └── 0d0103d582b4dc75610ca464e3e862c18c490c
│   │   ├── 3c
│   │   │   ├── 4d8b3f0559337735b0f543eeaffb97ba1568a2
│   │   │   ├── 68666a89071c92355acbc91553887f4baffa6b
│   │   │   └── 9047786447ee3c58f7e94fc6a36c51f82a852f
│   │   ├── 3d
│   │   │   ├── 6b1724dffa7c33f6f117cf34adf9e5e90a1841
│   │   │   └── eab5afdb9dab17db4ba44f1e46f79466ff40ef
│   │   ├── 3e
│   │   │   ├── 78cf761337bbed7fb6a869dc44d2853a3ca7ce
│   │   │   ├── cb2b26c5be9d683c8d234f1ff89f8d521627f4
│   │   │   └── cdd2d54baf3253124e062dea24c6583571591d
│   │   ├── 3f
│   │   │   └── b8e164eccffdefe0fb66d79b68618f6c780879
│   │   ├── 40
│   │   │   ├── 924f858e903a322bb6a7c41a347b5430ad4ac5
│   │   │   ├── a256417a4b389272d3f54c48e309059bc6bf5d
│   │   │   └── ec9ac83f5d87e9a63a0a2126c1fd37836e91a0
│   │   ├── 41
│   │   │   └── cea93f0a0fd87102ffcf5c5a82d090e8f6b995
│   │   ├── 42
│   │   │   └── 2b57b48741cb7bc37a07ea85046cda043296c9
│   │   ├── 43
│   │   │   └── 0e213802bf1c89ec90adbfd4da14252d3adce2
│   │   ├── 44
│   │   │   ├── a7d23f83d0ef569c8eecb23d309848145c319d
│   │   │   └── ecfc0ac6138249858a472371f3388c127afc79
│   │   ├── 45
│   │   │   ├── 9dc044270447c833e29a4519174ed6b06660d6
│   │   │   └── cad400b993d853afdc6529f2fe0bc533844053
│   │   ├── 46
│   │   │   ├── a9404a406c1a2233ee67ae7cb712570456c123
│   │   │   ├── a9e08ff6e4a9621b6839e896f259e7024c39ad
│   │   │   ├── dcf273e04225f71911e4385520faf467157aa3
│   │   │   └── e6ca02eca50ae032e41765ee28ff6d0655d758
│   │   ├── 47
│   │   │   └── 1eb0fc9c2e065008fcc66d29a25cf9497b58f3
│   │   ├── 48
│   │   │   ├── 0f6fb38145217e295200f8d68ef63e76f90426
│   │   │   ├── 2c0f513c93c97ea3db679d72fbd0cba22df79d
│   │   │   └── b398e3d0dfd7e42590f7c69075542ef714616b
│   │   ├── 49
│   │   │   ├── 0c056753c646609168ae1645a6741585c7d706
│   │   │   ├── 4e56a5aa032e64645484a3373899e955d47e0e
│   │   │   ├── 84285117fe511f77710a2d8993e3d3ebabce9b
│   │   │   └── fdce30a3f0be4c61664081eae7e34e1cc014c8
│   │   ├── 4a
│   │   │   ├── 5202644ee29020fb832f7bf4da44c59704cc94
│   │   │   └── 67e3915156552602dcfe419874af9291c42530
│   │   ├── 4b
│   │   │   ├── 1b1eaa0ac6209a47fa79e432cfc129f4024571
│   │   │   └── fc249fed32302aff07762c5cbc0c8d09858e8b
│   │   ├── 4c
│   │   │   ├── 4ed03a904d653ce539da9cb00a75b118339a86
│   │   │   ├── 67f223fc0943935f6e9391ab439157883b58d6
│   │   │   └── 8c95558dd7aa2eaa4cd825ba38dbc0b836f9a6
│   │   ├── 4d
│   │   │   ├── 2725f0ee347dd41cbafccf1408bb85d84802f9
│   │   │   └── d0954076601e122cf70c480e1eac398fcfd266
│   │   ├── 4e
│   │   │   ├── 9535ea401c2132aa36f1eaec865e05cd071c5d
│   │   │   ├── a72a911af2d782f20b992e808276bb838718d8
│   │   │   ├── e20a6ba1de51baccbb9da74d556016fb6d72b4
│   │   │   └── ebf3af189ebbb324e5927fbd216b490377027e
│   │   ├── 4f
│   │   │   ├── 1de04c4e2821c91f55e600c1c43fe1782f47c4
│   │   │   └── b77a997e3e351e9b297352762ca5d61512eb45
│   │   ├── 50
│   │   │   ├── c918346928f17f35a700cafe673a811a4a3c5f
│   │   │   ├── e421550d75ec1a06088625667fb3d664784ae6
│   │   │   └── f136c5235d76c9fe6deb140b5d7dfe8509c3c1
│   │   ├── 51
│   │   │   ├── 5fabaaa8934eaa23f0357dbb53f7a0a566be1b
│   │   │   └── 7d65a3a88d0d3b0c03fb219955bf02e66e120b
│   │   ├── 52
│   │   │   └── da2ac94104e8da86217b0cf4e7b6ecb3657119
│   │   ├── 53
│   │   │   ├── 6371d44ece4604be1e08a5bf5b45c62a73952f
│   │   │   └── 92ef8a342356ed3b2ce2b3da112bf8059da48e
│   │   ├── 54
│   │   │   ├── 1f6b739079f5a3b73930c2de282b0b785448c3
│   │   │   ├── 31ef545763ad178feca6f58ee86296705a1816
│   │   │   ├── 33210f01d6abd9f0a3ecf4637ec4594ace8849
│   │   │   ├── 3adf4668b1090f287ffbd8d4063c3d173da51c
│   │   │   ├── 7648a4d859f7964d6685974da4d6a10589d3ea
│   │   │   ├── 8081db51119fdd895b776844d0fe824dc9f685
│   │   │   ├── b1b2b866719ff8e38d6df212c40a67562b1723
│   │   │   └── d76deb7a93016c111d25591be7d357a1bbbd76
│   │   ├── 55
│   │   │   ├── ce4c042a157de017763a089c4575390e089a02
│   │   │   └── f3af8f1363b9374a56391fd2dbb85ede3ae60b
│   │   ├── 56
│   │   │   └── 081da0ae12443af7d830981b698fc4875fc946
│   │   ├── 58
│   │   │   ├── 8d9e95a281ce02e4dd1f8852c4398a50a0eeba
│   │   │   └── 8ff3ce1a94046f679c55e38e64a536d210ada6
│   │   ├── 59
│   │   │   ├── 4db93d321d5e74c23661c4e219f73021b2169a
│   │   │   └── 6bbf09b38378b91a31e5aea5f032f294d7ad04
│   │   ├── 5a
│   │   │   └── 2be2c1c1a177d841b47e4350f761892c10d545
│   │   ├── 5b
│   │   │   ├── 0346b0dcd06dd7979751bfd679e661da7e834c
│   │   │   ├── 7076ed45c598a1b96f81757eed974be9d98b31
│   │   │   └── d3b01d6bea677ae1466a2649675e7e015f0762
│   │   ├── 5c
│   │   │   └── fb4074bfea1a6e31c538be4b3ac62292562f13
│   │   ├── 5d
│   │   │   ├── 2f8feb2393c4f652f6bc9122c5728e0a49159a
│   │   │   ├── 7c623548233142990e622201bdcf71ab6ace8a
│   │   │   ├── c4a013de4ed150ca053c0ef820750e56463b4d
│   │   │   ├── e7c826cd0b875642d82fd552c89bbae98ceec1
│   │   │   └── f2916901cf214975fdc28801658308b9f5d53b
│   │   ├── 5e
│   │   │   ├── 083a65a5a61aaae20b049f0c02f030f26d288b
│   │   │   ├── abd728522e33774c7aa99cb6f77bf67b165991
│   │   │   └── b4d2b09dd512cd4573499a3bf19098b48fffe6
│   │   ├── 5f
│   │   │   └── e9c1a8d62b350cf7a9e41c00d5a6047e0c8015
│   │   ├── 60
│   │   │   ├── 1ae789bab1ee2cd44b702766cf00f694dfa3d4
│   │   │   ├── 3e543e597f8f5a9421258e20be8c64b93c1408
│   │   │   └── 70ef327113a3b4fb6efe41f4546ca444409d10
│   │   ├── 61
│   │   │   ├── 39b619bfa62d8dbdfb7c49260d3bff3ac74dae
│   │   │   └── 86e435b689de2896b3afa89e00580092e2f872
│   │   ├── 62
│   │   │   ├── 23385a2acc757b9dae25d73679ef71c95b0a61
│   │   │   └── a380b0bccfe29076ecfd9e3a98b526b1ad8786
│   │   ├── 63
│   │   │   ├── 216e0ff6f62b7e8b388cfe489b1f1f21622c0e
│   │   │   ├── a8e388d85f17889a8033d3f104b4e13828c587
│   │   │   └── d29df944a1a9826c0a962263e37b3d25a25c14
│   │   ├── 64
│   │   │   └── 39d3617d1be614155986753799ab2e3ce5a7cd
│   │   ├── 65
│   │   │   ├── b340e47d7bb104f5f639e36c1101159df7764a
│   │   │   └── d1c234010e8cffb6903526bf9a5c63f655e50f
│   │   ├── 66
│   │   │   ├── 2166fe5e1f97b5c8b58cf87d179b00e94633c1
│   │   │   ├── 958a04eb7c2e429a1528e060bd4251f45a496e
│   │   │   └── b688a0693b614e8d4ef769a7748928658d4862
│   │   ├── 67
│   │   │   ├── 612fa596848cc9fb6d898613179a8f7eb9f36e
│   │   │   └── c82d8ee6bac166428e0878907ce4e7c097e5b8
│   │   ├── 68
│   │   │   ├── 4b6b0465a9aab9ca9241af3130b516d2301823
│   │   │   └── edbff49f7ae8c5a1f3e3ec14a83520cbcef988
│   │   ├── 69
│   │   │   ├── 5013a0997e33dfb08d41e4293beeebb2f024e6
│   │   │   ├── 7014a7ab18273654d2dcaa15e86639b1d13797
│   │   │   ├── bbb350e0d79680a34641713bbb764b48d52339
│   │   │   └── f2e9eea0496df95cf0c4dec82c28e6036be64d
│   │   ├── 6a
│   │   │   ├── 76e8b2577ca61e14f359791ab3c0c30759d636
│   │   │   ├── caf67db55e1aef4174e2a386b6e6f3420e6bb3
│   │   │   ├── d2b3236d4f574bda7bcee098f815644269f356
│   │   │   └── e3a079f453fcad9cbc877a2758e0ae70b84ed5
│   │   ├── 6b
│   │   │   └── 7efc080165a78880ab92fb3367f7d5cc766651
│   │   ├── 6c
│   │   │   ├── 396a2275d2d3192ee55f56801c78043038345c
│   │   │   ├── 6c65592a2efbf1438fc8a58213981c55e0f54a
│   │   │   └── e72c8e337ef176feceefa5070607b2e64fb087
│   │   ├── 6d
│   │   │   ├── 185bdf346ad90ffcdae7472bd02cdd00078a66
│   │   │   ├── 31549454d9cf8d3ccaf3e71e102172781347db
│   │   │   ├── 3330bec0853cf698f885e238af0eabbc67276f
│   │   │   └── a2503e024f531ff6b8ef40e1196be0d789ada9
│   │   ├── 6e
│   │   │   ├── 4b086906a75641b4ba7a2703de424143bacd33
│   │   │   └── 85f97f9dac4a5c030a22c9627118f9141b5aa3
│   │   ├── 6f
│   │   │   ├── 199bfd310c6afbec8e94d0643f6510369e9954
│   │   │   ├── 319f95c7655dd89bee00622281e25c70aa6b1c
│   │   │   └── 9b7c62a32d75869280a63e64f52d2e55feb621
│   │   ├── 70
│   │   │   ├── 203c54356f7d3e30b33c66280d76c91e95c195
│   │   │   ├── 375c6019b960ec0258b2ffae589d3767fc9017
│   │   │   ├── 54a878f8267018981f80d3685439fada4ebd87
│   │   │   └── c8e2bd1383d391af8857648081b7a0d7bdab36
│   │   ├── 71
│   │   │   ├── 0302e1dbfc122df8b4a227c1d9f3e031562465
│   │   │   ├── 0a3e1e1dd568b9c7566733bc87a3bd7a01ef78
│   │   │   ├── 404cb53423fa8a471e183276fdc0dc0d5dc590
│   │   │   └── f6ac2a03c4c624f9658ca5225f3e397c8f8230
│   │   ├── 72
│   │   │   └── b2af7bc55d1514663e0ffd8bcd1e0f024e63ed
│   │   ├── 73
│   │   │   └── 93cde9f2fa9b9b6c4f1d78025fafd0b03047ab
│   │   ├── 74
│   │   │   ├── 18be78844b8a65026862d16cca4f0a0d80d9f5
│   │   │   └── 48833c2cc6e8d54c04bc1270084040f1738c10
│   │   ├── 75
│   │   │   └── 2593a17ee6d3b4dae5ec6c9df73e9f88a9acc4
│   │   ├── 76
│   │   │   ├── 0615c92f89894d5e6311f6f0839e5ffe6369f5
│   │   │   ├── 9e32c92d2b6db6b46b4688b2ee43289da99f77
│   │   │   └── b8037554886fba86fcfbbceed226ee6c6299dc
│   │   ├── 77
│   │   │   └── c992fc3cb828083b0ffc9ce72796c8de15f969
│   │   ├── 78
│   │   │   ├── 10d387ed4f4c47c68118355c853b3cae05f2f7
│   │   │   └── 171f69efb32bc2cab017b68849411e9b65027d
│   │   ├── 7a
│   │   │   ├── b09bcbf53e374ca54ab88382e360b651e6b075
│   │   │   ├── df5bead64ba38d5d7766b3002d2fa11e05f985
│   │   │   ├── f05324c5f0cd379b680d299a64e1c6d4281ab4
│   │   │   └── ff85f6c595001a3a906af662a1b4a285e73ab7
│   │   ├── 7b
│   │   │   ├── 1bcd65281a58d027ce4ee66d84bee0a569439a
│   │   │   ├── a03e8a24341ff676fed067557c29900312471e
│   │   │   ├── c739e39cead89dcf438b54740252faa743980c
│   │   │   └── f9395b64372c875ea105f9ae6da881f3a706d6
│   │   ├── 7d
│   │   │   ├── 125ef9f1a75b1254efc460807b0ad6ec178793
│   │   │   └── 7e2051a136b967d7e1314f3644d75c1799a261
│   │   ├── 7e
│   │   │   ├── 01218b7be266cab4a625dd5c1533c0b2ea7dbc
│   │   │   ├── 159603a49456c0126f089f6ab117c7c5a5a314
│   │   │   └── 423bac72059f715da05276d671e70b270312f4
│   │   ├── 7f
│   │   │   ├── 677823af89be2b565609d9a9bc3912839c1d00
│   │   │   ├── 7e742e67ec678d13c1d10d8137c0b4be38a941
│   │   │   ├── 89227328f3eecfd2c201cb71f7e3275cd32f3e
│   │   │   ├── b34a00d9bbfd51064fcd28bd80e6e1aef1f713
│   │   │   ├── c6e66b8d3760de1a4fa521d08bdaa1b746c4fc
│   │   │   └── d672c080f0b39ae0774486e071d7fc4bab2eba
│   │   ├── 80
│   │   │   ├── 13d09d03ac8157b613527dec7033b8c21c4b42
│   │   │   └── f81d4a6aa5b0ebd2979f9af0e351f1f9f703b5
│   │   ├── 81
│   │   │   ├── cdcfc96f7d50633aa18855edb6b7a8bc388985
│   │   │   └── f43a245ee03eab892cf2a2c2cbff739495d3bf
│   │   ├── 82
│   │   │   ├── 0cecbde8227d45cda5add97515530cbbb227be
│   │   │   ├── 8d0e5db15fb0336326f708d3bb9a2deeae306a
│   │   │   └── d0f5bfd4181f9a060ef4301f465729807b167a
│   │   ├── 83
│   │   │   └── 6fedb5f56fb553de4a387bfd61f28eac04398f
│   │   ├── 84
│   │   │   ├── 6b3b68e24749947ce7f90dbd403efb0ce67dbc
│   │   │   ├── 9036761b7c375b6fa2c503b85c2af3cad632bf
│   │   │   └── f621f80389b8d8b2fd8645d8f9feae87cda3b9
│   │   ├── 86
│   │   │   ├── 30984cf5854ad3fe17b5cc48ea268581aa3353
│   │   │   ├── 47ab2f89ebdd646d2c217885459a7dbb677d8f
│   │   │   ├── 6ea58ce543ffa305f14f12ad2936b39d4e334f
│   │   │   ├── ce067f79ce552391b690918c128a4d8179f56a
│   │   │   └── f63880ddcd5b4e0cf288593996fb0b515cdc4c
│   │   ├── 87
│   │   │   └── 9459b21cce3be49092b10ea81867d18a66c922
│   │   ├── 88
│   │   │   ├── 5ad25a40c282252d2e51aa10bdaeb7d8412099
│   │   │   ├── 6dd7006f64e5e37a0c46a9f1ed385d50f78d8e
│   │   │   └── b32773c7fa68ae1e8a4ab5815d6a4cacea51a4
│   │   ├── 89
│   │   │   ├── c9551bf141f029ecd588fe408ef512d4180bd4
│   │   │   └── e53d5d6f897ecf3e11ab0fea6e2fff3eab9752
│   │   ├── 8a
│   │   │   ├── 1464aedc253823409a9b9be8e9b87f0ad8569b
│   │   │   └── f972cded0d3e3ccb3c6e801150168bcc93150a
│   │   ├── 8b
│   │   │   ├── 3753f10d06e6091b79413a3d9d48852b03dc75
│   │   │   ├── 9371bdd55311f1080f9da8f312a22ed250af4e
│   │   │   ├── 9adedfadbf3c4817769606af5fc02d984a7abb
│   │   │   └── ca8b6acb204b13e167e069ef2c7e6b76f55527
│   │   ├── 8c
│   │   │   └── a7122c1a6960d15e6a70c91cf2cf9033fccffb
│   │   ├── 8e
│   │   │   ├── 089bd3894bf260310541d63468d15a575db652
│   │   │   ├── 3a503878de4c911cc9724639b1e1e57d9b09fd
│   │   │   └── 7001f13138ea6b3ec015da2d0a511497663e80
│   │   ├── 8f
│   │   │   ├── 498260b8d691b9024544f2596b68ca16e7361c
│   │   │   ├── 8c9767f588bfbcad7b1cfa4cb2eff3d5009acb
│   │   │   ├── 92ce13cdad46fc7c0e9280c4a9f70cad08dac4
│   │   │   └── fa010f027791420c0bb7e070ae9f35d27fefd0
│   │   ├── 90
│   │   │   ├── a920d482916363d0ae20fa2382e7e45f775ff2
│   │   │   └── bec3a517feb7a926b5f7fe4bc8737d9b3795a1
│   │   ├── 91
│   │   │   ├── ad1a30d887e886f71e30b58259d4bfdb014f34
│   │   │   ├── db566efcff16d8a77f888d562aa01d840caea3
│   │   │   ├── f53a895b571da0a48f54c32eb4b66a2f93716c
│   │   │   └── f99d86ad70b0fe3b95fb7ff910ab9caadbfeb5
│   │   ├── 93
│   │   │   ├── 09454d4648edc6f38e2dfb8db996ff7b7a0925
│   │   │   ├── 1322607995605853de5167558e7e2affea1fef
│   │   │   └── 7ae70ba297bf1de19a15e2c99255d512b4f662
│   │   ├── 94
│   │   │   ├── 08a4f0bf80754306c09612f42f9bdf859761b2
│   │   │   └── 860a5decc0c7239da0c9a09b58dd22828a0d52
│   │   ├── 95
│   │   │   ├── 16472a614f74ee47bedf7ea31dee6360338a75
│   │   │   └── 4e1d4bfe6010c9940c66d0d585810d5bdbdf07
│   │   ├── 96
│   │   │   ├── 5c3de0a856d30cf22c2b7d7a585be512c6ffc2
│   │   │   └── b4cf29ee30262736d69a4504cc6dc467235b5c
│   │   ├── 97
│   │   │   ├── 3632dd4bd2babecda486315d16d1544b0fc4c0
│   │   │   ├── 84dc9af9a4a04124fb9efdc7dd2d2ab8f7580a
│   │   │   ├── d29ba491a46fd75b3d8d8019a20531d6f29c36
│   │   │   └── e609f32344c3b3639639128645722d530f9450
│   │   ├── 98
│   │   │   ├── 4135816c72ae3e710c584913aaaadd35331d93
│   │   │   ├── 4db3acce08cf016d6c38cf289b86b7a48d9ffc
│   │   │   ├── 53ff5b4b3ab7df743425ea425dbf67e72988df
│   │   │   └── 93188e11e5beffc0d6cd3b1703f7bb4ecacb8f
│   │   ├── 99
│   │   │   ├── 7ba99370adfd76be385a9462f6ecf6036b04bf
│   │   │   └── f88f926b36a31dd1c1458d862c5e45cb6ca311
│   │   ├── 9a
│   │   │   ├── 45ad89768c4c2495a71cf298b3a1bb783b3bfe
│   │   │   ├── a3d815f9e0ea8afbec4a702cbc35bd485a2e86
│   │   │   └── c42689cb60cef8b8872bd6e8864fb1840b6b00
│   │   ├── 9b
│   │   │   ├── 088755db5090c354b281c8435ba04c2501d873
│   │   │   ├── 2d9069eb9d1f015292651a77d106eb7012fed0
│   │   │   ├── 4354c24c23115ad6d163f1845c4284a011d638
│   │   │   ├── 52963d4af77c4b751213b93b1a033677b8902d
│   │   │   ├── 6d7bbb7934f91b6855912c7a9b6f83fd1b5736
│   │   │   └── fae772a1bb49ec9c38725ee9cd9d93957e094f
│   │   ├── 9c
│   │   │   ├── 6cb7e7d2a9c4e3aade9c239a87ced31662b06e
│   │   │   ├── 842e5bdc288d43e7abf837fd3bf8fb25bbdfc0
│   │   │   └── bc9f7218e24fd5a7ed5d1285bf18fe4c46bbed
│   │   ├── 9d
│   │   │   └── f3ed7bc1dd5df12caac030e9a8f2702571c512
│   │   ├── 9e
│   │   │   └── 88bed80663b97515ef7d8014fc008b4fc29c33
│   │   ├── 9f
│   │   │   ├── 259201dcc88289d5bb9688dfa72e2efcecd33a
│   │   │   ├── 3f8246827b93ccd8d5f2025b33149582381a64
│   │   │   ├── 90c96056b533ebbbe2b2e01490ad233bc86485
│   │   │   ├── d13f680e7883cfd861d9a3ce185f889cbf97b5
│   │   │   ├── d722e915980e8a66cd42232b83be437d5c0b01
│   │   │   └── ff85e3503d066bc793b544d9bc4786752643ac
│   │   ├── a1
│   │   │   └── b99d2bf32fb03c333ffea84bd628ce9f52a882
│   │   ├── a3
│   │   │   ├── 0017211a1f3726f40049359662001927f32cac
│   │   │   ├── 30c292491b4cab63f7f54f3c039fbbe5a1a108
│   │   │   └── 45bd276336c56212af13d06fbb8a89bfe558b8
│   │   ├── a4
│   │   │   ├── 71f1e164087c4374519e62f0beea0f1275361a
│   │   │   ├── 7713c0749bd35b88177b1e5bc9f700b4f0d8c0
│   │   │   └── b935378cb96233e8b20ad714a3572b69cddff0
│   │   ├── a5
│   │   │   └── 24cda0a3626ed14c4248ac45be9214d513e9ae
│   │   ├── a7
│   │   │   ├── 71ec673dfbf21101642f69e681acc49bb1065f
│   │   │   └── f4f60411899c7f312fa3f4601a88b2e651b6ca
│   │   ├── a8
│   │   │   └── 9f7d1734d9c2ea126a8e507066096d2e9e8ff8
│   │   ├── a9
│   │   │   ├── 1bb3fa2f3583161fb6da13c875e88e85865ba3
│   │   │   ├── 573860eb6043b29f209f92b0ad967d14d0be4f
│   │   │   ├── a805d6c5e7cb17591e6fbd4d95c58a75705a99
│   │   │   └── f4ea521165f0b66947dbcdbbc9af4e23daabd0
│   │   ├── aa
│   │   │   ├── 97152ed7e8cfa13f98b6073f8d95efbb14b7c1
│   │   │   └── aabb3cb9fe5724e930d5a7f25f84afb29cfb37
│   │   ├── ac
│   │   │   └── daf82b24700219ac3ddcc55cc922285bc16a49
│   │   ├── ad
│   │   │   ├── 060f31fdac2b9517c63ac77ef49285275efdf4
│   │   │   ├── 1e274a5521335bc352d2054db96eefb84c4598
│   │   │   └── e1ecd10ceb8ef28c15c250573346643385cc6d
│   │   ├── ae
│   │   │   ├── 0a1236141c748fd997b8ac9e5d91450ae82397
│   │   │   └── 239953ee632e8cbd3fb3af082cda59bfab2a47
│   │   ├── af
│   │   │   ├── 65c674d83f251ef157ab0d325db16d9e0a5e3f
│   │   │   ├── 65d446e714bd11230fbedde456d32e4841d1f4
│   │   │   ├── 7671ac571662a1ac35e5576543953fad16801c
│   │   │   ├── 8224c42680a46be844c02a830db6313b467c7d
│   │   │   ├── 834ec419053ad1adc7c43c19de3df45bb7e495
│   │   │   └── a7e3f0956347957cca31357f97064b580112fb
│   │   ├── b1
│   │   │   ├── 6af5d0fccaa01e0ef589eedc0b862de80b2156
│   │   │   └── affd5cafc2c8c4616743f1625a144e4326e1ed
│   │   ├── b2
│   │   │   └── 75656224e969b7e4516aa0f592d2f1f311fdc5
│   │   ├── b3
│   │   │   └── f98c080a51bb8b5953726894fd910a25036787
│   │   ├── b4
│   │   │   ├── ab89a327e095905554a92c4907d303beff77ff
│   │   │   ├── b91fb9a5ef7caf9cc859bde262e1295f263a00
│   │   │   └── fb1369f6eef5693a9a3c1bd7914ae2482424d4
│   │   ├── b5
│   │   │   └── d94976318e23339a392453b0475543077a18e6
│   │   ├── b6
│   │   │   ├── 4414115ac48517f58471384f1633455db7ad5e
│   │   │   └── 49ff7c0fed9316a19a54b66ac2d8949b1790bd
│   │   ├── b7
│   │   │   ├── 5c1972dbf7c8758e2180ef6c34c3d0be954218
│   │   │   ├── 6be741ff14887838b15a52ba9abefdd9d796d7
│   │   │   ├── 9b77be229e2099a1bcd571bb5670c50fa35abe
│   │   │   └── dd2fa5de2bf662fabfbab24a2efc20c6d3cdb4
│   │   ├── b8
│   │   │   ├── 21b905f38f0d18ed4b35d3ed511a4af8933d04
│   │   │   └── 551535a0c9a53158ae4f984b76e69136e61163
│   │   ├── b9
│   │   │   ├── 1ba243986a443578623d4877857093e3d75235
│   │   │   ├── 8dbe79b1928ac23499071f48b91ceba68d4543
│   │   │   └── d63324c8d97bf1d71150241068a29aa7717e88
│   │   ├── ba
│   │   │   ├── 086238999e59555ed32a19d1b36630273e0ec8
│   │   │   ├── 0acb93cec233cf4a272949bf812dd1e0e4e386
│   │   │   ├── e476116fc572992afd332a0e22ae03174b59ea
│   │   │   └── efbf56f0c9347f5413a2d320a9f1986a8fd44a
│   │   ├── bb
│   │   │   └── 45333209e2bfe63e71a946ad97f632e76824a0
│   │   ├── bc
│   │   │   ├── b5380a2b8d64400642b9af1ab8be94290c2c67
│   │   │   └── f7cb80c9b0ec5265d973ee28e88dfa30917ff3
│   │   ├── be
│   │   │   └── 41138e0d9eed08adaa96e0c5c0486cb3331978
│   │   ├── bf
│   │   │   ├── 2ab68f918b444b850db1b6760178e089c2c8c2
│   │   │   ├── 3f4049491d91dfc5cea8b0164027d18e84bae4
│   │   │   └── 747481c40b7d8380a0af7edada3e526786c30d
│   │   ├── c0
│   │   │   ├── 0adaefc60f4e8dd7aa709eea82fd5a5adef9dc
│   │   │   └── dcd0223c1330d878604bc60863553e7f444151
│   │   ├── c1
│   │   │   ├── 00fe08d21129f9625a3dc1bbca17218329aadd
│   │   │   ├── 70125d75a953647186e04892a5e3afb37ed5a4
│   │   │   ├── a4b9803cecf3ccc9578499e1169fd39e507298
│   │   │   ├── cc055ade1c21e82d3471a90f185d74866b0eb1
│   │   │   └── fd900f7827df06f034036ffe0bc0231d9e6249
│   │   ├── c2
│   │   │   ├── 065bc26202b2d072aca3efc3d1c2efad3afcbf
│   │   │   └── d2da97509214182091072d1fc2fc5737d620df
│   │   ├── c3
│   │   │   ├── 36f9e14a5f12a75f197b9326d54c276234b2a2
│   │   │   ├── 529fc008ee18029db4e0f854925c43403d525d
│   │   │   ├── 5a2ff381d474928502f5b330b9714031883163
│   │   │   ├── 678c4253bcef24b3e785e42de5c84037b6444d
│   │   │   └── 8fb4596461fc3f3e296b83a8a9b7409cb69399
│   │   ├── c4
│   │   │   ├── 0c29f02cd63e713d0a687add80eb41b5684863
│   │   │   ├── 585c7818bd135906ef6e71300308fc1603b562
│   │   │   └── dcf5dda32a6b0a6a03cc3b1e54d18e7673370c
│   │   ├── c6
│   │   │   ├── 60993aefe1f552502519ff5d5a380ab0f2da1f
│   │   │   └── e6666b714fefe606504cd615bacc93c25318d5
│   │   ├── c7
│   │   │   ├── cb018433bf0eb7a299fc57d113121f8def7426
│   │   │   └── fc27dd90884f82b12728c3def84e49a8014f56
│   │   ├── c9
│   │   │   └── e9fcf4f921c5e87b200dafd0188b175a956cfb
│   │   ├── ca
│   │   │   ├── 65a42b149f936e04c5d3fbe5a7b3a13f933d3a
│   │   │   └── d4277152e94faac677863d199ada407f6b07b5
│   │   ├── cb
│   │   │   └── 018d413966f8d2921cc0de488a29f6df21a57d
│   │   ├── cc
│   │   │   ├── 16b026d15d8b55f5825a893da689796b825e8d
│   │   │   ├── 54c6b63d7b2137a3375f63ad10b5a7c0d72ee0
│   │   │   ├── d90af9b75da257e254b00cb73882985bcc8e71
│   │   │   └── fba9ddaaa8ea708a0e5492aa5c56583e36e5b5
│   │   ├── cd
│   │   │   └── 73ed2494dce684de13de900e170cc8fa2883f0
│   │   ├── ce
│   │   │   ├── 2ea31f9c50f1acb7e8eaaaef6dd04e025785a4
│   │   │   ├── 32e9b4ef904520dcc517b5fb17f802ea9e0131
│   │   │   └── ced331389bc4f5e8830e2a29c11e2ba2c2809e
│   │   ├── cf
│   │   │   ├── 1a7b17efd30eded5053bfa29cee8dc2c33c7ce
│   │   │   ├── 2c21fe9cdcfac4a4b4ba23d93340458e63cd59
│   │   │   ├── a0d74863c1a8b40b027bc96ad5f3f98c25c7b5
│   │   │   ├── c8b2dc8bcd048fe6ecb6ed740f8341bc1a839d
│   │   │   └── ea2494a7c5fecb5ca37be24bd140d6d3ce6ac3
│   │   ├── d0
│   │   │   └── 519420524d6efec9e628076d541350087c7ff0
│   │   ├── d1
│   │   │   ├── 24cc5f7fd70f04e2ba64b9cf5b6ded1dc33a78
│   │   │   ├── 8de92fdee3c0a894e22be54aaf72e20cd6e0b3
│   │   │   ├── afaa629d09b2159d31410b7f4fb1d4fef54925
│   │   │   └── b8f3137a68d1fc10df633ecce7e9481d25064d
│   │   ├── d2
│   │   │   ├── 0c2a25116d0a793de393da352e0e50ea73a91a
│   │   │   ├── 4b246956f3f15bb702c99666ebdf7ff8c64989
│   │   │   ├── 6a04f41995e5c041d2cde2a971530aefafebe1
│   │   │   └── d960c2a1fdd41eb980a9c6245388e696f40a30
│   │   ├── d3
│   │   │   ├── 26819aebfc614eb3d5e86acd12483839386184
│   │   │   └── fcda3aad73b9b88213ca6cfb17d666deddee8e
│   │   ├── d4
│   │   │   └── 3b3e7146fbcb0e9be27cda17427a7b220a4f33
│   │   ├── d5
│   │   │   ├── 444c3d749ee07df00fa17d5050464ffa2b7625
│   │   │   └── eeb374bed084c9e070a8c78250d0934161182d
│   │   ├── d6
│   │   │   ├── 6056b60b377b35266ef0f36828c58a529eab23
│   │   │   └── 712b9bfe6bd9e55ed0f0b2f539e39f95e632c0
│   │   ├── d7
│   │   │   ├── 586fd25ed667a660fca90aaf8913dce8154eae
│   │   │   ├── ae41a12343c5c96ab494f9e59400e3de3095b7
│   │   │   ├── f942b8f1524a5fbf9bab34c804c870a280cdbc
│   │   │   └── fd0a4454e73a1535293025e1382cf6130b8fd2
│   │   ├── d9
│   │   │   └── a8a339e1ae8c4fdd40d2427b688db40cbf68fa
│   │   ├── da
│   │   │   ├── 417e80c3a7fb730ef63e110e9fa5f4e8920213
│   │   │   └── 80cf2cba1b654a07bdf86a476e2fccc94aeb35
│   │   ├── db
│   │   │   ├── 3a6ac207e507b0bc1635a9f2c18d3b174e682e
│   │   │   └── 517e7106b82186864a7c07832ef11efaf8c596
│   │   ├── dc
│   │   │   └── 596f5ef0a7e709adea61b3901345001688a1e5
│   │   ├── dd
│   │   │   └── f4912024e432066f221fd6b571483dd60a609e
│   │   ├── de
│   │   │   ├── 35bef54533803c3f81ff34eea761b037fdcc48
│   │   │   ├── 4ebf487d9f309a7b768dfeca13bd4586ecf95a
│   │   │   ├── 99e36fc40eba9a3af26daeb0207e6bf2e27749
│   │   │   ├── d9188567b84bb2de452b77e17100e0483eb6cc
│   │   │   ├── e8b45f0b45661fc71b00cd62b4c0604d611d67
│   │   │   └── f27e9ea4178a785b4ded1bfd3748143e58aa84
│   │   ├── df
│   │   │   ├── 794b36b4a8298341e714a3eb8b457eaab75457
│   │   │   ├── 8a0bea3ce74211935fd62f0ecd8b32e1e7ab5b
│   │   │   ├── 9891a3ce23fcc9b35dfad8130dc2dd23f3db5c
│   │   │   └── d023831b9e9764de8a65888c0f409745e20625
│   │   ├── e0
│   │   │   ├── 3fec37fc6d00af735770cddf037f0af4bf11e6
│   │   │   ├── 869ce0c8164e9caebc9f737787c94740aa6fd5
│   │   │   └── e872011c5d27fdb09959697df7561f2439cd5d
│   │   ├── e2
│   │   │   └── fe054583a2eb2cd8e5f27c4e5507d59163a58b
│   │   ├── e5
│   │   │   └── b6231c3a97f9b2b3e45a89335a48bb3ee1ae22
│   │   ├── e6
│   │   │   ├── 949924279c2648de7295930ba6bf97e8c36de0
│   │   │   └── af61df37f74a31df68f428dd8d23049e47c66b
│   │   ├── e7
│   │   │   ├── 2683a1d6e4f10fea7c9fc292a71f5e3f63e339
│   │   │   ├── 26c9a6bbd8ab51e9892f654a2f1537d8ecbf09
│   │   │   ├── 5fe562746e789c5c13d05aa796c01f014012dc
│   │   │   └── af8928639fdc4249a4b27d10f71f05dcc606a5
│   │   ├── e8
│   │   │   ├── 231d7835cec0fa860686e7c0224a4e150e9ddb
│   │   │   ├── 5316446ea4d63a57e9f0be8cdeee69a1cf3984
│   │   │   ├── d4ca4a9ef5d25b077509293b4796e1625ed4bd
│   │   │   └── ff0db904fa9cf1372106180b2b1225fb69c637
│   │   ├── ea
│   │   │   ├── 1f2129ba450b6d2637d4471eee638bbc04ae2b
│   │   │   ├── 82256b00a369f6cd62e01f2533c1ac7eeaa49a
│   │   │   └── d6a0cc19ecac194b39848c8c96c98e819f2fc8
│   │   ├── eb
│   │   │   ├── 0e300c0836b21f24a641ebc73731b8c6c61024
│   │   │   ├── 178ae1c5db4caf5e7fc6035618edbfa7490daf
│   │   │   ├── 5a867f2ff052adf6c93f594a01ac8a94b08ceb
│   │   │   └── fef6366208f85c12e8dd5319f3d5235c981c9f
│   │   ├── ec
│   │   │   ├── 372ee4f06ffa634be9c5b8c4fe1fa365b0ee32
│   │   │   ├── 8c6447d9bc1ec41804e6cfa4383b9cb509c0ac
│   │   │   ├── cda78df131c68ef6afd5b61fcce587ee1d346f
│   │   │   └── d2082e77f0d0bdb527bc7987d2a1a92b7d17be
│   │   ├── ed
│   │   │   ├── 5a2c7b291a63dba271cfde24611c4243635e7e
│   │   │   ├── 7e7a432ffdc6eccc74f4a1dbfc717abfde36c5
│   │   │   ├── a00452ce87a72fab2c3c7ee097eabf37435610
│   │   │   ├── a023e2c1de88215b746ee1e28bc41c227dbac3
│   │   │   ├── b873148b5d26398dbce9691c6d403e0291682f
│   │   │   └── c55ceba21494580628ac2d691341e7596c6272
│   │   ├── ee
│   │   │   ├── a1e43238ef9f70bdd41c7b8a9d23a930994f37
│   │   │   ├── adcfaf1afd07bde2379872ee15a0216dd6d30d
│   │   │   ├── dd08a6ae59a2e95c476246c7919a16f24136b0
│   │   │   └── e34a4a5f4c9c96e8d0bed85718c01657010077
│   │   ├── ef
│   │   │   ├── 2de90e010a985568803da7a8a3a8067861e6f9
│   │   │   └── 85b72f10e266564cec22c1ef336f91323ca720
│   │   ├── f0
│   │   │   ├── 48282b14413b009ed07dd2512220ccb15d8ad1
│   │   │   └── 7db140724684b90db697f67bbc9ec45b29844f
│   │   ├── f1
│   │   │   ├── 19bd68ea98955625eeee32f24fbc7c381027b0
│   │   │   ├── 7a933804da88b00bd0e3445c8393fbad68bb24
│   │   │   └── ebc6c950af88698eec17611e7bcb1bc9f8b920
│   │   ├── f2
│   │   │   ├── 4a263f521ed88fc20577e725894c10663c9be3
│   │   │   ├── 57a799fac7b7821d1b66a40be1712d11cbc6bd
│   │   │   └── 7a5650f8a447fda301c877348923375cbc2af3
│   │   ├── f4
│   │   │   ├── 2044e0745baa2889cdee4df40c157c12f753bd
│   │   │   ├── 58f4b5bf636447dfeef3dc6072b5abf0be746e
│   │   │   ├── acba20e2d85636746fba5e136719e95c1c6689
│   │   │   └── f19ed01bd6f17c745789723d181c7a474c22ca
│   │   ├── f5
│   │   │   ├── 98016dd28614085891115fa044d6295483c3ee
│   │   │   ├── 9f7486e5351888f27c1d9fc2607bb77f2cc387
│   │   │   └── bfa71bf758bf822e2803fd37c5c49d9519aa64
│   │   ├── f6
│   │   │   ├── 4c90fc0c6909bd32af2210bfd98994b5617673
│   │   │   ├── 569cc178f92a0c61275a29cc1f90cd896a4570
│   │   │   └── b2e83c097132202c084e576b6bc91d2afc8104
│   │   ├── f7
│   │   │   ├── 5ea9141a4b1e87cc5b6650a380964027eb5bdd
│   │   │   └── cd43e8391ea385cecc5f6b0342234ec04077a0
│   │   ├── f8
│   │   │   ├── 325409c8b15d035a3fdd05a8e74dcab6be27d0
│   │   │   ├── 4cd49c7b287b62912be0c55299dfebeeb47a03
│   │   │   ├── 6e2c2aee889efbf2bd96634d314f5b151a6fce
│   │   │   └── 9942b59644b3cc43ae2dab0fb955d390b13276
│   │   ├── f9
│   │   │   └── f77d41989193a174d364b7ab1b1330bce4c76f
│   │   ├── fa
│   │   │   ├── 4c5f9da52a544f2226db7c50cbb325a28f6b08
│   │   │   └── db9e390ddddb58ef7ae5d8655dd45f931c0c46
│   │   ├── fb
│   │   │   ├── 7f080d45a76120c09066a0ef8aa9629afbdb60
│   │   │   ├── aedbb521a6d9162c1ec99a0361ad2c78714a60
│   │   │   ├── cb7c9606e521d0c46269c90a6b18daf803df29
│   │   │   └── ea722736f804e6717dc2053a79d2391de41d1e
│   │   ├── fc
│   │   │   ├── 286f56042d518d9edfedf107de1141acc19874
│   │   │   └── 75df57524bada2479fa46eb46bbaa24ccb98d8
│   │   ├── fd
│   │   │   ├── 749fbcc1af63c6a8df50ba0f9bcffc20ca7d76
│   │   │   ├── 8e08c2e28c68f79ab52ce97cf5f0645cf4a89b
│   │   │   ├── c1c6d1b11eec633ab695cf459de97ad6a72216
│   │   │   └── d6fe6840b582a0bc764d6a692aaf46c6c6c9fa
│   │   ├── fe
│   │   │   ├── 03e7a58e826882d05ad2018df0e99216c22855
│   │   │   └── 1d21a29cc905132502a3e5b3d02a6a2553c151
│   │   ├── info
│   │   └── pack
│   ├── refs
│   │   ├── heads
│   │   │   └── main
│   │   ├── remotes
│   │   │   └── origin
│   │   │       └── main
│   │   ├── tags
│   │   └── stash
│   ├── COMMIT_EDITMSG
│   ├── config
│   ├── description
│   ├── FETCH_HEAD
│   ├── HEAD
│   ├── index
│   └── ORIG_HEAD
├── .github
│   ├── java-upgrade
│   │   ├── hooks
│   │   │   └── scripts
│   │   │       ├── recordToolUse.ps1
│   │   │       └── recordToolUse.sh
│   │   └── .gitignore
│   └── modernize
│       └── java-upgrade
│           ├── hooks
│           │   └── scripts
│           │       ├── recordToolUse.ps1
│           │       └── recordToolUse.sh
│           └── .gitignore
├── .vscode
│   └── settings.json
├── accounts_movements_service
│   ├── .idea
│   │   ├── copilot.data.migration.agent.xml
│   │   ├── gradle.xml
│   │   ├── misc.xml
│   │   └── workspace.xml
│   └── accounts_movements_service
│       ├── .gradle
│       │   ├── 8.14.4
│       │   │   ├── checksums
│       │   │   │   ├── checksums.lock
│       │   │   │   ├── md5-checksums.bin
│       │   │   │   └── sha1-checksums.bin
│       │   │   ├── executionHistory
│       │   │   │   ├── executionHistory.bin
│       │   │   │   └── executionHistory.lock
│       │   │   ├── expanded
│       │   │   │   └── expanded.lock
│       │   │   ├── fileChanges
│       │   │   │   └── last-build.bin
│       │   │   ├── fileHashes
│       │   │   │   ├── fileHashes.bin
│       │   │   │   ├── fileHashes.lock
│       │   │   │   └── resourceHashesCache.bin
│       │   │   ├── vcsMetadata
│       │   │   └── gc.properties
│       │   ├── buildOutputCleanup
│       │   │   ├── buildOutputCleanup.lock
│       │   │   ├── cache.properties
│       │   │   └── outputFiles.bin
│       │   ├── vcs-1
│       │   │   └── gc.properties
│       │   └── file-system.probe
│       ├── .idea
│       │   ├── modules
│       │   ├── .gitignore
│       │   ├── compiler.xml
│       │   ├── copilot.data.migration.agent.xml
│       │   ├── gradle.xml
│       │   ├── misc.xml
│       │   ├── vcs.xml
│       │   └── workspace.xml
│       ├── build
│       │   ├── classes
│       │   │   └── java
│       │   │       ├── main
│       │   │       │   └── com
│       │   │       │       └── challenge
│       │   │       │           └── accounts_movements_service
│       │   │       │               ├── application
│       │   │       │               │   ├── input
│       │   │       │               │   │   └── port
│       │   │       │               │   │       ├── AccountInputPort.class
│       │   │       │               │   │       ├── MovementInputPort.class
│       │   │       │               │   │       └── ReportInputPort.class
│       │   │       │               │   ├── output
│       │   │       │               │   │   └── port
│       │   │       │               │   │       ├── AccountRepositoryPort.class
│       │   │       │               │   │       ├── CustomerRepositoryPort.class
│       │   │       │               │   │       └── MovementRepositoryPort.class
│       │   │       │               │   ├── service
│       │   │       │               │   │   └── impl
│       │   │       │               │   │       ├── AccountServiceImpl.class
│       │   │       │               │   │       ├── MovementServiceImpl.class
│       │   │       │               │   │       └── ReportServiceImpl.class
│       │   │       │               │   └── util
│       │   │       │               │       ├── Constants.class
│       │   │       │               │       └── PagedResult.class
│       │   │       │               ├── domain
│       │   │       │               │   ├── exception
│       │   │       │               │   │   ├── AccountInactiveException.class
│       │   │       │               │   │   ├── AccountNotFoundException.class
│       │   │       │               │   │   ├── CustomerNotFoundException.class
│       │   │       │               │   │   ├── DomainException.class
│       │   │       │               │   │   ├── DomainValidationException.class
│       │   │       │               │   │   ├── DownstreamServiceException.class
│       │   │       │               │   │   ├── DuplicatedAccountNumberException.class
│       │   │       │               │   │   ├── InsufficientFundsException.class
│       │   │       │               │   │   └── MovementNotFoundException.class
│       │   │       │               │   ├── model
│       │   │       │               │   │   ├── Account$AccountBuilder.class
│       │   │       │               │   │   ├── Account.class
│       │   │       │               │   │   ├── AccountStatementReport$AccountStatementReportBuilder.class
│       │   │       │               │   │   ├── AccountStatementReport.class
│       │   │       │               │   │   ├── AccountStatementReportAccount$AccountStatementReportAccountBuilder.class
│       │   │       │               │   │   ├── AccountStatementReportAccount.class
│       │   │       │               │   │   ├── AccountStatementReportMovement$AccountStatementReportMovementBuilder.class
│       │   │       │               │   │   ├── AccountStatementReportMovement.class
│       │   │       │               │   │   ├── AccountType.class
│       │   │       │               │   │   ├── Movement$MovementBuilder.class
│       │   │       │               │   │   ├── Movement.class
│       │   │       │               │   │   └── MovementType.class
│       │   │       │               │   ├── policy
│       │   │       │               │   │   ├── MovementPolicy$1.class
│       │   │       │               │   │   └── MovementPolicy.class
│       │   │       │               │   └── util
│       │   │       │               │       └── Constants.class
│       │   │       │               ├── infrastructure
│       │   │       │               │   ├── exception
│       │   │       │               │   │   └── GlobalExceptionHandler.class
│       │   │       │               │   ├── input
│       │   │       │               │   │   └── adapter
│       │   │       │               │   │       ├── controller
│       │   │       │               │   │       │   ├── AccountsController.class
│       │   │       │               │   │       │   ├── MovementsController.class
│       │   │       │               │   │       │   └── ReportController.class
│       │   │       │               │   │       ├── mapper
│       │   │       │               │   │       │   ├── AccountRestMapper$1.class
│       │   │       │               │   │       │   ├── AccountRestMapper.class
│       │   │       │               │   │       │   ├── AccountRestMapperImpl.class
│       │   │       │               │   │       │   ├── MovementRestMapper$1.class
│       │   │       │               │   │       │   ├── MovementRestMapper.class
│       │   │       │               │   │       │   ├── MovementRestMapperImpl.class
│       │   │       │               │   │       │   ├── ReportRestMapper$1.class
│       │   │       │               │   │       │   ├── ReportRestMapper.class
│       │   │       │               │   │       │   └── ReportRestMapperImpl.class
│       │   │       │               │   │       └── rest
│       │   │       │               │   │           └── customer_service
│       │   │       │               │   │               ├── bean
│       │   │       │               │   │               │   ├── AccountBase.class
│       │   │       │               │   │               │   ├── AccountResponse.class
│       │   │       │               │   │               │   ├── AccountStatementAccount.class
│       │   │       │               │   │               │   ├── AccountStatementReport.class
│       │   │       │               │   │               │   ├── AccountType.class
│       │   │       │               │   │               │   ├── ApiError.class
│       │   │       │               │   │               │   ├── ApiErrorDetailsInner.class
│       │   │       │               │   │               │   ├── CreateAccountRequest.class
│       │   │       │               │   │               │   ├── CreateMovementRequest.class
│       │   │       │               │   │               │   ├── MovementBase.class
│       │   │       │               │   │               │   ├── MovementResponse.class
│       │   │       │               │   │               │   ├── MovementType.class
│       │   │       │               │   │               │   ├── PagedAccountsResponse.class
│       │   │       │               │   │               │   ├── PagedMovementsResponse.class
│       │   │       │               │   │               │   ├── UpdateAccountRequest.class
│       │   │       │               │   │               │   └── UpdateMovementRequest.class
│       │   │       │               │   │               ├── AccountsApi.class
│       │   │       │               │   │               ├── ApiUtil.class
│       │   │       │               │   │               ├── MovementsApi.class
│       │   │       │               │   │               └── ReportsApi.class
│       │   │       │               │   ├── output
│       │   │       │               │   │   ├── adapter
│       │   │       │               │   │   │   ├── entity
│       │   │       │               │   │   │   │   ├── AccountEntity$AccountEntityBuilder.class
│       │   │       │               │   │   │   │   ├── AccountEntity.class
│       │   │       │               │   │   │   │   ├── MovementEntity$MovementEntityBuilder.class
│       │   │       │               │   │   │   │   └── MovementEntity.class
│       │   │       │               │   │   │   ├── mapper
│       │   │       │               │   │   │   │   ├── AccountJpaMapper.class
│       │   │       │               │   │   │   │   ├── AccountJpaMapperImpl.class
│       │   │       │               │   │   │   │   ├── MovementJpaMapper.class
│       │   │       │               │   │   │   │   └── MovementJpaMapperImpl.class
│       │   │       │               │   │   │   ├── repository
│       │   │       │               │   │   │   │   ├── AccountJpaRepository.class
│       │   │       │               │   │   │   │   └── MovementJpaRepository.class
│       │   │       │               │   │   │   ├── rest
│       │   │       │               │   │   │   │   ├── auth
│       │   │       │               │   │   │   │   │   ├── ApiKeyAuth.class
│       │   │       │               │   │   │   │   │   ├── Authentication.class
│       │   │       │               │   │   │   │   │   ├── HttpBasicAuth.class
│       │   │       │               │   │   │   │   │   └── HttpBearerAuth.class
│       │   │       │               │   │   │   │   ├── customer_service
│       │   │       │               │   │   │   │   │   ├── bean
│       │   │       │               │   │   │   │   │   │   ├── ApiError.class
│       │   │       │               │   │   │   │   │   │   ├── ApiErrorDetailsInner.class
│       │   │       │               │   │   │   │   │   │   ├── CreateCustomerRequest.class
│       │   │       │               │   │   │   │   │   │   ├── Customer.class
│       │   │       │               │   │   │   │   │   │   ├── CustomerFields.class
│       │   │       │               │   │   │   │   │   │   ├── CustomerResponse.class
│       │   │       │               │   │   │   │   │   │   ├── Gender.class
│       │   │       │               │   │   │   │   │   │   ├── PagedCustomersResponse.class
│       │   │       │               │   │   │   │   │   │   ├── PersonBase.class
│       │   │       │               │   │   │   │   │   │   └── UpdateCustomerRequest.class
│       │   │       │               │   │   │   │   │   ├── CustomersApi$1.class
│       │   │       │               │   │   │   │   │   ├── CustomersApi$10.class
│       │   │       │               │   │   │   │   │   ├── CustomersApi$11.class
│       │   │       │               │   │   │   │   │   ├── CustomersApi$12.class
│       │   │       │               │   │   │   │   │   ├── CustomersApi$13.class
│       │   │       │               │   │   │   │   │   ├── CustomersApi$14.class
│       │   │       │               │   │   │   │   │   ├── CustomersApi$15.class
│       │   │       │               │   │   │   │   │   ├── CustomersApi$16.class
│       │   │       │               │   │   │   │   │   ├── CustomersApi$17.class
│       │   │       │               │   │   │   │   │   ├── CustomersApi$18.class
│       │   │       │               │   │   │   │   │   ├── CustomersApi$19.class
│       │   │       │               │   │   │   │   │   ├── CustomersApi$2.class
│       │   │       │               │   │   │   │   │   ├── CustomersApi$20.class
│       │   │       │               │   │   │   │   │   ├── CustomersApi$21.class
│       │   │       │               │   │   │   │   │   ├── CustomersApi$22.class
│       │   │       │               │   │   │   │   │   ├── CustomersApi$23.class
│       │   │       │               │   │   │   │   │   ├── CustomersApi$24.class
│       │   │       │               │   │   │   │   │   ├── CustomersApi$25.class
│       │   │       │               │   │   │   │   │   ├── CustomersApi$3.class
│       │   │       │               │   │   │   │   │   ├── CustomersApi$4.class
│       │   │       │               │   │   │   │   │   ├── CustomersApi$5.class
│       │   │       │               │   │   │   │   │   ├── CustomersApi$6.class
│       │   │       │               │   │   │   │   │   ├── CustomersApi$7.class
│       │   │       │               │   │   │   │   │   ├── CustomersApi$8.class
│       │   │       │               │   │   │   │   │   ├── CustomersApi$9.class
│       │   │       │               │   │   │   │   │   └── CustomersApi.class
│       │   │       │               │   │   │   │   ├── ApiClient$CollectionFormat.class
│       │   │       │               │   │   │   │   ├── ApiClient.class
│       │   │       │               │   │   │   │   ├── JavaTimeFormatter.class
│       │   │       │               │   │   │   │   ├── RFC3339DateFormat.class
│       │   │       │               │   │   │   │   ├── ServerConfiguration.class
│       │   │       │               │   │   │   │   ├── ServerVariable.class
│       │   │       │               │   │   │   │   └── StringUtil.class
│       │   │       │               │   │   │   ├── AccountRepositoryAdapter.class
│       │   │       │               │   │   │   ├── CustomerRepositoryAdapter.class
│       │   │       │               │   │   │   └── MovementRepositoryAdapter.class
│       │   │       │               │   │   └── config
│       │   │       │               │   │       ├── ApiClientConfiguration.class
│       │   │       │               │   │       └── MovementPolicyConfiguration.class
│       │   │       │               │   └── util
│       │   │       │               │       └── Constants.class
│       │   │       │               └── AccountsMovementsServiceApplication.class
│       │   │       └── test
│       │   │           └── com
│       │   │               └── challenge
│       │   │                   └── accounts_movements_service
│       │   │                       ├── application
│       │   │                       │   └── service
│       │   │                       │       └── impl
│       │   │                       │           ├── AccountServiceImplTest.class
│       │   │                       │           ├── MovementServiceImplTest.class
│       │   │                       │           └── ReportServiceImplTest.class
│       │   │                       ├── domain
│       │   │                       │   ├── exception
│       │   │                       │   │   ├── AccountInactiveExceptionTest.class
│       │   │                       │   │   ├── AccountNotFoundExceptionTest.class
│       │   │                       │   │   ├── CustomerNotFoundExceptionTest.class
│       │   │                       │   │   ├── DomainExceptionTest$DummyDomainException.class
│       │   │                       │   │   ├── DomainExceptionTest.class
│       │   │                       │   │   ├── DomainValidationExceptionTest.class
│       │   │                       │   │   ├── DownstreamServiceExceptionTest.class
│       │   │                       │   │   ├── DuplicatedAccountNumberExceptionTest.class
│       │   │                       │   │   ├── InsufficientFundsExceptionTest.class
│       │   │                       │   │   └── MovementNotFoundExceptionTest.class
│       │   │                       │   ├── model
│       │   │                       │   │   ├── AccountStatementReportAccountTest.class
│       │   │                       │   │   ├── AccountStatementReportMovementTest.class
│       │   │                       │   │   ├── AccountStatementReportTest.class
│       │   │                       │   │   ├── AccountTest.class
│       │   │                       │   │   ├── AccountTypeTest.class
│       │   │                       │   │   ├── MovementTest.class
│       │   │                       │   │   └── MovementTypeTest.class
│       │   │                       │   └── policy
│       │   │                       │       └── MovementPolicyTest.class
│       │   │                       ├── infrastructure
│       │   │                       │   ├── exception
│       │   │                       │   │   └── GlobalExceptionHandlerTest.class
│       │   │                       │   ├── input
│       │   │                       │   │   └── adapter
│       │   │                       │   │       └── controller
│       │   │                       │   │           ├── AccountsControllerTest.class
│       │   │                       │   │           ├── MovementsControllerTest.class
│       │   │                       │   │           └── ReportControllerTest.class
│       │   │                       │   └── output
│       │   │                       │       └── adapter
│       │   │                       │           ├── entity
│       │   │                       │           │   ├── AccountEntityTest.class
│       │   │                       │           │   └── MovementEntityTest.class
│       │   │                       │           ├── mapper
│       │   │                       │           │   ├── AccountJpaMapperTest.class
│       │   │                       │           │   └── MovementJpaMapperTest.class
│       │   │                       │           ├── AccountRepositoryAdapterTest.class
│       │   │                       │           ├── CustomerRepositoryAdapterTest.class
│       │   │                       │           └── MovementRepositoryAdapterTest.class
│       │   │                       └── AccountsMovementsServiceApplicationTests.class
│       │   ├── generated
│       │   │   ├── .github
│       │   │   │   └── workflows
│       │   │   │       └── maven.yml
│       │   │   ├── .openapi-generator
│       │   │   │   ├── FILES
│       │   │   │   └── VERSION
│       │   │   ├── api
│       │   │   │   └── openapi.yaml
│       │   │   ├── docs
│       │   │   │   ├── ApiError.md
│       │   │   │   ├── ApiErrorDetailsInner.md
│       │   │   │   ├── CreateCustomerRequest.md
│       │   │   │   ├── Customer.md
│       │   │   │   ├── CustomerFields.md
│       │   │   │   ├── CustomerResponse.md
│       │   │   │   ├── CustomersApi.md
│       │   │   │   ├── Gender.md
│       │   │   │   ├── PagedCustomersResponse.md
│       │   │   │   ├── PersonBase.md
│       │   │   │   └── UpdateCustomerRequest.md
│       │   │   ├── gradle
│       │   │   │   └── wrapper
│       │   │   │       ├── gradle-wrapper.jar
│       │   │   │       └── gradle-wrapper.properties
│       │   │   ├── sources
│       │   │   │   ├── annotationProcessor
│       │   │   │   │   └── java
│       │   │   │   │       ├── main
│       │   │   │   │       │   └── com
│       │   │   │   │       │       └── challenge
│       │   │   │   │       │           └── accounts_movements_service
│       │   │   │   │       │               └── infrastructure
│       │   │   │   │       │                   ├── input
│       │   │   │   │       │                   │   └── adapter
│       │   │   │   │       │                   │       └── mapper
│       │   │   │   │       │                   │           ├── AccountRestMapperImpl.java
│       │   │   │   │       │                   │           ├── MovementRestMapperImpl.java
│       │   │   │   │       │                   │           └── ReportRestMapperImpl.java
│       │   │   │   │       │                   └── output
│       │   │   │   │       │                       └── adapter
│       │   │   │   │       │                           └── mapper
│       │   │   │   │       │                               ├── AccountJpaMapperImpl.java
│       │   │   │   │       │                               └── MovementJpaMapperImpl.java
│       │   │   │   │       └── test
│       │   │   │   └── headers
│       │   │   │       └── java
│       │   │   │           ├── main
│       │   │   │           └── test
│       │   │   ├── src
│       │   │   │   ├── main
│       │   │   │   │   ├── java
│       │   │   │   │   │   └── com
│       │   │   │   │   │       └── challenge
│       │   │   │   │   │           └── accounts_movements_service
│       │   │   │   │   │               └── infrastructure
│       │   │   │   │   │                   ├── input
│       │   │   │   │   │                   │   └── adapter
│       │   │   │   │   │                   │       └── rest
│       │   │   │   │   │                   │           └── customer_service
│       │   │   │   │   │                   │               ├── bean
│       │   │   │   │   │                   │               │   ├── AccountBase.java
│       │   │   │   │   │                   │               │   ├── AccountResponse.java
│       │   │   │   │   │                   │               │   ├── AccountStatementAccount.java
│       │   │   │   │   │                   │               │   ├── AccountStatementReport.java
│       │   │   │   │   │                   │               │   ├── AccountType.java
│       │   │   │   │   │                   │               │   ├── ApiError.java
│       │   │   │   │   │                   │               │   ├── ApiErrorDetailsInner.java
│       │   │   │   │   │                   │               │   ├── CreateAccountRequest.java
│       │   │   │   │   │                   │               │   ├── CreateMovementRequest.java
│       │   │   │   │   │                   │               │   ├── MovementBase.java
│       │   │   │   │   │                   │               │   ├── MovementResponse.java
│       │   │   │   │   │                   │               │   ├── MovementType.java
│       │   │   │   │   │                   │               │   ├── PagedAccountsResponse.java
│       │   │   │   │   │                   │               │   ├── PagedMovementsResponse.java
│       │   │   │   │   │                   │               │   ├── UpdateAccountRequest.java
│       │   │   │   │   │                   │               │   └── UpdateMovementRequest.java
│       │   │   │   │   │                   │               ├── AccountsApi.java
│       │   │   │   │   │                   │               ├── ApiUtil.java
│       │   │   │   │   │                   │               ├── MovementsApi.java
│       │   │   │   │   │                   │               └── ReportsApi.java
│       │   │   │   │   │                   └── output
│       │   │   │   │   │                       └── adapter
│       │   │   │   │   │                           └── rest
│       │   │   │   │   │                               ├── auth
│       │   │   │   │   │                               │   ├── ApiKeyAuth.java
│       │   │   │   │   │                               │   ├── Authentication.java
│       │   │   │   │   │                               │   ├── HttpBasicAuth.java
│       │   │   │   │   │                               │   └── HttpBearerAuth.java
│       │   │   │   │   │                               ├── customer_service
│       │   │   │   │   │                               │   ├── bean
│       │   │   │   │   │                               │   │   ├── ApiError.java
│       │   │   │   │   │                               │   │   ├── ApiErrorDetailsInner.java
│       │   │   │   │   │                               │   │   ├── CreateCustomerRequest.java
│       │   │   │   │   │                               │   │   ├── Customer.java
│       │   │   │   │   │                               │   │   ├── CustomerFields.java
│       │   │   │   │   │                               │   │   ├── CustomerResponse.java
│       │   │   │   │   │                               │   │   ├── Gender.java
│       │   │   │   │   │                               │   │   ├── PagedCustomersResponse.java
│       │   │   │   │   │                               │   │   ├── PersonBase.java
│       │   │   │   │   │                               │   │   └── UpdateCustomerRequest.java
│       │   │   │   │   │                               │   └── CustomersApi.java
│       │   │   │   │   │                               ├── ApiClient.java
│       │   │   │   │   │                               ├── JavaTimeFormatter.java
│       │   │   │   │   │                               ├── RFC3339DateFormat.java
│       │   │   │   │   │                               ├── ServerConfiguration.java
│       │   │   │   │   │                               ├── ServerVariable.java
│       │   │   │   │   │                               └── StringUtil.java
│       │   │   │   │   └── AndroidManifest.xml
│       │   │   │   └── test
│       │   │   │       └── java
│       │   │   │           └── com
│       │   │   │               └── challenge
│       │   │   │                   └── accounts_movements_service
│       │   │   │                       └── infrastructure
│       │   │   │                           └── output
│       │   │   │                               └── adapter
│       │   │   │                                   └── rest
│       │   │   │                                       └── customer_service
│       │   │   │                                           ├── bean
│       │   │   │                                           │   ├── ApiErrorDetailsInnerTest.java
│       │   │   │                                           │   ├── ApiErrorTest.java
│       │   │   │                                           │   ├── CreateCustomerRequestTest.java
│       │   │   │                                           │   ├── CustomerFieldsTest.java
│       │   │   │                                           │   ├── CustomerResponseTest.java
│       │   │   │                                           │   ├── CustomerTest.java
│       │   │   │                                           │   ├── GenderTest.java
│       │   │   │                                           │   ├── PagedCustomersResponseTest.java
│       │   │   │                                           │   ├── PersonBaseTest.java
│       │   │   │                                           │   └── UpdateCustomerRequestTest.java
│       │   │   │                                           └── CustomersApiTest.java
│       │   │   ├── .gitignore
│       │   │   ├── .openapi-generator-ignore
│       │   │   ├── .travis.yml
│       │   │   ├── build.gradle
│       │   │   ├── build.sbt
│       │   │   ├── git_push.sh
│       │   │   ├── gradle.properties
│       │   │   ├── gradlew
│       │   │   ├── gradlew.bat
│       │   │   ├── pom.xml
│       │   │   ├── README.md
│       │   │   └── settings.gradle
│       │   ├── jacoco
│       │   │   └── test.exec
│       │   ├── libs
│       │   │   ├── accounts_movements_service-0.0.1-SNAPSHOT-plain.jar
│       │   │   └── accounts_movements_service-0.0.1-SNAPSHOT.jar
│       │   ├── reports
│       │   │   ├── jacoco
│       │   │   │   └── test
│       │   │   │       ├── html
│       │   │   │       │   ├── com.challenge.accounts_movements_service
│       │   │   │       │   │   ├── AccountsMovementsServiceApplication.html
│       │   │   │       │   │   ├── AccountsMovementsServiceApplication.java.html
│       │   │   │       │   │   ├── index.html
│       │   │   │       │   │   └── index.source.html
│       │   │   │       │   ├── com.challenge.accounts_movements_service.application.service.impl
│       │   │   │       │   │   ├── AccountServiceImpl.html
│       │   │   │       │   │   ├── AccountServiceImpl.java.html
│       │   │   │       │   │   ├── index.html
│       │   │   │       │   │   ├── index.source.html
│       │   │   │       │   │   ├── MovementServiceImpl.html
│       │   │   │       │   │   ├── MovementServiceImpl.java.html
│       │   │   │       │   │   ├── ReportServiceImpl.html
│       │   │   │       │   │   └── ReportServiceImpl.java.html
│       │   │   │       │   ├── com.challenge.accounts_movements_service.application.util
│       │   │   │       │   │   ├── index.html
│       │   │   │       │   │   ├── index.source.html
│       │   │   │       │   │   ├── PagedResult.html
│       │   │   │       │   │   └── PagedResult.java.html
│       │   │   │       │   ├── com.challenge.accounts_movements_service.domain.exception
│       │   │   │       │   │   ├── AccountInactiveException.html
│       │   │   │       │   │   ├── AccountInactiveException.java.html
│       │   │   │       │   │   ├── AccountNotFoundException.html
│       │   │   │       │   │   ├── AccountNotFoundException.java.html
│       │   │   │       │   │   ├── CustomerNotFoundException.html
│       │   │   │       │   │   ├── CustomerNotFoundException.java.html
│       │   │   │       │   │   ├── DomainException.html
│       │   │   │       │   │   ├── DomainException.java.html
│       │   │   │       │   │   ├── DomainValidationException.html
│       │   │   │       │   │   ├── DomainValidationException.java.html
│       │   │   │       │   │   ├── DownstreamServiceException.html
│       │   │   │       │   │   ├── DownstreamServiceException.java.html
│       │   │   │       │   │   ├── DuplicatedAccountNumberException.html
│       │   │   │       │   │   ├── DuplicatedAccountNumberException.java.html
│       │   │   │       │   │   ├── index.html
│       │   │   │       │   │   ├── index.source.html
│       │   │   │       │   │   ├── InsufficientFundsException.html
│       │   │   │       │   │   ├── InsufficientFundsException.java.html
│       │   │   │       │   │   ├── MovementNotFoundException.html
│       │   │   │       │   │   └── MovementNotFoundException.java.html
│       │   │   │       │   ├── com.challenge.accounts_movements_service.domain.model
│       │   │   │       │   │   ├── AccountType.html
│       │   │   │       │   │   ├── AccountType.java.html
│       │   │   │       │   │   ├── index.html
│       │   │   │       │   │   ├── index.source.html
│       │   │   │       │   │   ├── MovementType.html
│       │   │   │       │   │   └── MovementType.java.html
│       │   │   │       │   ├── com.challenge.accounts_movements_service.domain.policy
│       │   │   │       │   │   ├── index.html
│       │   │   │       │   │   ├── index.source.html
│       │   │   │       │   │   ├── MovementPolicy.html
│       │   │   │       │   │   └── MovementPolicy.java.html
│       │   │   │       │   ├── com.challenge.accounts_movements_service.infrastructure.exception
│       │   │   │       │   │   ├── GlobalExceptionHandler.html
│       │   │   │       │   │   ├── GlobalExceptionHandler.java.html
│       │   │   │       │   │   ├── index.html
│       │   │   │       │   │   └── index.source.html
│       │   │   │       │   ├── com.challenge.accounts_movements_service.infrastructure.input.adapter.controller
│       │   │   │       │   │   ├── AccountsController.html
│       │   │   │       │   │   ├── AccountsController.java.html
│       │   │   │       │   │   ├── index.html
│       │   │   │       │   │   ├── index.source.html
│       │   │   │       │   │   ├── MovementsController.html
│       │   │   │       │   │   ├── MovementsController.java.html
│       │   │   │       │   │   ├── ReportController.html
│       │   │   │       │   │   └── ReportController.java.html
│       │   │   │       │   ├── com.challenge.accounts_movements_service.infrastructure.input.adapter.mapper
│       │   │   │       │   │   ├── AccountRestMapper.html
│       │   │   │       │   │   ├── AccountRestMapper.java.html
│       │   │   │       │   │   ├── AccountRestMapperImpl.html
│       │   │   │       │   │   ├── index.html
│       │   │   │       │   │   ├── index.source.html
│       │   │   │       │   │   ├── MovementRestMapper.html
│       │   │   │       │   │   ├── MovementRestMapper.java.html
│       │   │   │       │   │   ├── MovementRestMapperImpl.html
│       │   │   │       │   │   ├── ReportRestMapper.html
│       │   │   │       │   │   ├── ReportRestMapper.java.html
│       │   │   │       │   │   └── ReportRestMapperImpl.html
│       │   │   │       │   ├── com.challenge.accounts_movements_service.infrastructure.input.adapter.rest.customer_service
│       │   │   │       │   │   ├── ApiUtil.html
│       │   │   │       │   │   ├── ApiUtil.java.html
│       │   │   │       │   │   ├── index.html
│       │   │   │       │   │   └── index.source.html
│       │   │   │       │   ├── com.challenge.accounts_movements_service.infrastructure.input.adapter.rest.customer_service.bean
│       │   │   │       │   │   ├── AccountBase.html
│       │   │   │       │   │   ├── AccountBase.java.html
│       │   │   │       │   │   ├── AccountResponse.html
│       │   │   │       │   │   ├── AccountResponse.java.html
│       │   │   │       │   │   ├── AccountStatementAccount.html
│       │   │   │       │   │   ├── AccountStatementAccount.java.html
│       │   │   │       │   │   ├── AccountStatementReport.html
│       │   │   │       │   │   ├── AccountStatementReport.java.html
│       │   │   │       │   │   ├── AccountType.html
│       │   │   │       │   │   ├── AccountType.java.html
│       │   │   │       │   │   ├── ApiError.html
│       │   │   │       │   │   ├── ApiError.java.html
│       │   │   │       │   │   ├── ApiErrorDetailsInner.html
│       │   │   │       │   │   ├── ApiErrorDetailsInner.java.html
│       │   │   │       │   │   ├── CreateAccountRequest.html
│       │   │   │       │   │   ├── CreateAccountRequest.java.html
│       │   │   │       │   │   ├── CreateMovementRequest.html
│       │   │   │       │   │   ├── CreateMovementRequest.java.html
│       │   │   │       │   │   ├── index.html
│       │   │   │       │   │   ├── index.source.html
│       │   │   │       │   │   ├── MovementBase.html
│       │   │   │       │   │   ├── MovementBase.java.html
│       │   │   │       │   │   ├── MovementResponse.html
│       │   │   │       │   │   ├── MovementResponse.java.html
│       │   │   │       │   │   ├── MovementType.html
│       │   │   │       │   │   ├── MovementType.java.html
│       │   │   │       │   │   ├── PagedAccountsResponse.html
│       │   │   │       │   │   ├── PagedAccountsResponse.java.html
│       │   │   │       │   │   ├── PagedMovementsResponse.html
│       │   │   │       │   │   ├── PagedMovementsResponse.java.html
│       │   │   │       │   │   ├── UpdateAccountRequest.html
│       │   │   │       │   │   ├── UpdateAccountRequest.java.html
│       │   │   │       │   │   ├── UpdateMovementRequest.html
│       │   │   │       │   │   └── UpdateMovementRequest.java.html
│       │   │   │       │   ├── com.challenge.accounts_movements_service.infrastructure.output.adapter
│       │   │   │       │   │   ├── AccountRepositoryAdapter.html
│       │   │   │       │   │   ├── AccountRepositoryAdapter.java.html
│       │   │   │       │   │   ├── CustomerRepositoryAdapter.html
│       │   │   │       │   │   ├── CustomerRepositoryAdapter.java.html
│       │   │   │       │   │   ├── index.html
│       │   │   │       │   │   ├── index.source.html
│       │   │   │       │   │   ├── MovementRepositoryAdapter.html
│       │   │   │       │   │   └── MovementRepositoryAdapter.java.html
│       │   │   │       │   ├── com.challenge.accounts_movements_service.infrastructure.output.adapter.mapper
│       │   │   │       │   │   ├── AccountJpaMapperImpl.html
│       │   │   │       │   │   ├── index.html
│       │   │   │       │   │   ├── index.source.html
│       │   │   │       │   │   └── MovementJpaMapperImpl.html
│       │   │   │       │   ├── com.challenge.accounts_movements_service.infrastructure.output.adapter.rest
│       │   │   │       │   │   ├── ApiClient$CollectionFormat.html
│       │   │   │       │   │   ├── ApiClient.html
│       │   │   │       │   │   ├── ApiClient.java.html
│       │   │   │       │   │   ├── index.html
│       │   │   │       │   │   ├── index.source.html
│       │   │   │       │   │   ├── JavaTimeFormatter.html
│       │   │   │       │   │   ├── JavaTimeFormatter.java.html
│       │   │   │       │   │   ├── RFC3339DateFormat.html
│       │   │   │       │   │   ├── RFC3339DateFormat.java.html
│       │   │   │       │   │   ├── ServerConfiguration.html
│       │   │   │       │   │   ├── ServerConfiguration.java.html
│       │   │   │       │   │   ├── ServerVariable.html
│       │   │   │       │   │   ├── ServerVariable.java.html
│       │   │   │       │   │   ├── StringUtil.html
│       │   │   │       │   │   └── StringUtil.java.html
│       │   │   │       │   ├── com.challenge.accounts_movements_service.infrastructure.output.adapter.rest.auth
│       │   │   │       │   │   ├── ApiKeyAuth.html
│       │   │   │       │   │   ├── ApiKeyAuth.java.html
│       │   │   │       │   │   ├── HttpBasicAuth.html
│       │   │   │       │   │   ├── HttpBasicAuth.java.html
│       │   │   │       │   │   ├── HttpBearerAuth.html
│       │   │   │       │   │   ├── HttpBearerAuth.java.html
│       │   │   │       │   │   ├── index.html
│       │   │   │       │   │   └── index.source.html
│       │   │   │       │   ├── com.challenge.accounts_movements_service.infrastructure.output.adapter.rest.customer_service
│       │   │   │       │   │   ├── CustomersApi$1.html
│       │   │   │       │   │   ├── CustomersApi$10.html
│       │   │   │       │   │   ├── CustomersApi$11.html
│       │   │   │       │   │   ├── CustomersApi$12.html
│       │   │   │       │   │   ├── CustomersApi$13.html
│       │   │   │       │   │   ├── CustomersApi$14.html
│       │   │   │       │   │   ├── CustomersApi$15.html
│       │   │   │       │   │   ├── CustomersApi$16.html
│       │   │   │       │   │   ├── CustomersApi$17.html
│       │   │   │       │   │   ├── CustomersApi$18.html
│       │   │   │       │   │   ├── CustomersApi$19.html
│       │   │   │       │   │   ├── CustomersApi$2.html
│       │   │   │       │   │   ├── CustomersApi$20.html
│       │   │   │       │   │   ├── CustomersApi$21.html
│       │   │   │       │   │   ├── CustomersApi$22.html
│       │   │   │       │   │   ├── CustomersApi$23.html
│       │   │   │       │   │   ├── CustomersApi$24.html
│       │   │   │       │   │   ├── CustomersApi$25.html
│       │   │   │       │   │   ├── CustomersApi$3.html
│       │   │   │       │   │   ├── CustomersApi$4.html
│       │   │   │       │   │   ├── CustomersApi$5.html
│       │   │   │       │   │   ├── CustomersApi$6.html
│       │   │   │       │   │   ├── CustomersApi$7.html
│       │   │   │       │   │   ├── CustomersApi$8.html
│       │   │   │       │   │   ├── CustomersApi$9.html
│       │   │   │       │   │   ├── CustomersApi.html
│       │   │   │       │   │   ├── CustomersApi.java.html
│       │   │   │       │   │   ├── index.html
│       │   │   │       │   │   └── index.source.html
│       │   │   │       │   ├── com.challenge.accounts_movements_service.infrastructure.output.adapter.rest.customer_service.bean
│       │   │   │       │   │   ├── ApiError.html
│       │   │   │       │   │   ├── ApiError.java.html
│       │   │   │       │   │   ├── ApiErrorDetailsInner.html
│       │   │   │       │   │   ├── ApiErrorDetailsInner.java.html
│       │   │   │       │   │   ├── CreateCustomerRequest.html
│       │   │   │       │   │   ├── CreateCustomerRequest.java.html
│       │   │   │       │   │   ├── Customer.html
│       │   │   │       │   │   ├── Customer.java.html
│       │   │   │       │   │   ├── CustomerFields.html
│       │   │   │       │   │   ├── CustomerFields.java.html
│       │   │   │       │   │   ├── CustomerResponse.html
│       │   │   │       │   │   ├── CustomerResponse.java.html
│       │   │   │       │   │   ├── Gender.html
│       │   │   │       │   │   ├── Gender.java.html
│       │   │   │       │   │   ├── index.html
│       │   │   │       │   │   ├── index.source.html
│       │   │   │       │   │   ├── PagedCustomersResponse.html
│       │   │   │       │   │   ├── PagedCustomersResponse.java.html
│       │   │   │       │   │   ├── PersonBase.html
│       │   │   │       │   │   ├── PersonBase.java.html
│       │   │   │       │   │   ├── UpdateCustomerRequest.html
│       │   │   │       │   │   └── UpdateCustomerRequest.java.html
│       │   │   │       │   ├── com.challenge.accounts_movements_service.infrastructure.output.config
│       │   │   │       │   │   ├── ApiClientConfiguration.html
│       │   │   │       │   │   ├── ApiClientConfiguration.java.html
│       │   │   │       │   │   ├── index.html
│       │   │   │       │   │   ├── index.source.html
│       │   │   │       │   │   ├── MovementPolicyConfiguration.html
│       │   │   │       │   │   └── MovementPolicyConfiguration.java.html
│       │   │   │       │   ├── jacoco-resources
│       │   │   │       │   │   ├── branchfc.gif
│       │   │   │       │   │   ├── branchnc.gif
│       │   │   │       │   │   ├── branchpc.gif
│       │   │   │       │   │   ├── bundle.gif
│       │   │   │       │   │   ├── class.gif
│       │   │   │       │   │   ├── down.gif
│       │   │   │       │   │   ├── greenbar.gif
│       │   │   │       │   │   ├── group.gif
│       │   │   │       │   │   ├── method.gif
│       │   │   │       │   │   ├── package.gif
│       │   │   │       │   │   ├── prettify.css
│       │   │   │       │   │   ├── prettify.js
│       │   │   │       │   │   ├── redbar.gif
│       │   │   │       │   │   ├── report.css
│       │   │   │       │   │   ├── report.gif
│       │   │   │       │   │   ├── session.gif
│       │   │   │       │   │   ├── sort.gif
│       │   │   │       │   │   ├── sort.js
│       │   │   │       │   │   ├── source.gif
│       │   │   │       │   │   └── up.gif
│       │   │   │       │   ├── index.html
│       │   │   │       │   └── jacoco-sessions.html
│       │   │   │       ├── jacocoTestReport.csv
│       │   │   │       └── jacocoTestReport.xml
│       │   │   ├── problems
│       │   │   │   └── problems-report.html
│       │   │   └── tests
│       │   │       └── test
│       │   │           ├── classes
│       │   │           │   └── com.challenge.accounts_movements_service.infrastructure.input.adapter.controller.AccountsControllerTest.html
│       │   │           ├── css
│       │   │           │   ├── base-style.css
│       │   │           │   └── style.css
│       │   │           ├── js
│       │   │           │   └── report.js
│       │   │           ├── packages
│       │   │           │   └── com.challenge.accounts_movements_service.infrastructure.input.adapter.controller.html
│       │   │           └── index.html
│       │   ├── resources
│       │   │   ├── main
│       │   │   │   ├── META-INF
│       │   │   │   │   └── build-info.properties
│       │   │   │   ├── openapi-templates
│       │   │   │   │   ├── client
│       │   │   │   │   │   ├── api.mustache
│       │   │   │   │   │   └── ApiClient.mustache
│       │   │   │   │   └── bodyParams.mustache
│       │   │   │   ├── application.yaml
│       │   │   │   ├── customer_service.yaml
│       │   │   │   └── openapi.yaml
│       │   │   └── test
│       │   │       ├── application-test.yaml
│       │   │       └── schema.sql
│       │   ├── test-results
│       │   │   └── test
│       │   │       ├── binary
│       │   │       │   ├── output.bin
│       │   │       │   ├── output.bin.idx
│       │   │       │   └── results.bin
│       │   │       └── TEST-com.challenge.accounts_movements_service.infrastructure.input.adapter.controller.AccountsControllerTest.xml
│       │   ├── tmp
│       │   │   ├── .cache
│       │   │   │   └── expanded
│       │   │   │       └── zip_9892ccb804f78c0637616b68610d363f
│       │   │   │           ├── META-INF
│       │   │   │           │   ├── maven
│       │   │   │           │   │   └── org.jacoco
│       │   │   │           │   │       └── org.jacoco.agent
│       │   │   │           │   │           ├── pom.properties
│       │   │   │           │   │           └── pom.xml
│       │   │   │           │   └── MANIFEST.MF
│       │   │   │           ├── org
│       │   │   │           │   └── jacoco
│       │   │   │           │       └── agent
│       │   │   │           │           ├── AgentJar.class
│       │   │   │           │           └── package-info.class
│       │   │   │           ├── about.html
│       │   │   │           └── jacocoagent.jar
│       │   │   ├── bootJar
│       │   │   │   └── MANIFEST.MF
│       │   │   ├── compileJava
│       │   │   │   ├── compileTransaction
│       │   │   │   │   ├── backup-dir
│       │   │   │   │   └── stash-dir
│       │   │   │   │       ├── AccountBase.class.uniqueId88
│       │   │   │   │       ├── AccountInputPort.class.uniqueId61
│       │   │   │   │       ├── AccountRepositoryAdapter.class.uniqueId0
│       │   │   │   │       ├── AccountRepositoryPort.class.uniqueId34
│       │   │   │   │       ├── AccountResponse.class.uniqueId85
│       │   │   │   │       ├── AccountRestMapper$1.class.uniqueId58
│       │   │   │   │       ├── AccountRestMapper.class.uniqueId64
│       │   │   │   │       ├── AccountRestMapperImpl.class.uniqueId38
│       │   │   │   │       ├── AccountRestMapperImpl.java.uniqueId33
│       │   │   │   │       ├── AccountsApi.class.uniqueId62
│       │   │   │   │       ├── AccountsController.class.uniqueId25
│       │   │   │   │       ├── AccountServiceImpl.class.uniqueId19
│       │   │   │   │       ├── AccountStatementAccount.class.uniqueId27
│       │   │   │   │       ├── AccountStatementReport.class.uniqueId47
│       │   │   │   │       ├── AccountType.class.uniqueId17
│       │   │   │   │       ├── ApiClient$CollectionFormat.class.uniqueId22
│       │   │   │   │       ├── ApiClient.class.uniqueId74
│       │   │   │   │       ├── ApiClientConfiguration.class.uniqueId55
│       │   │   │   │       ├── ApiError.class.uniqueId46
│       │   │   │   │       ├── ApiError.class.uniqueId9
│       │   │   │   │       ├── ApiErrorDetailsInner.class.uniqueId56
│       │   │   │   │       ├── ApiErrorDetailsInner.class.uniqueId60
│       │   │   │   │       ├── ApiKeyAuth.class.uniqueId14
│       │   │   │   │       ├── CreateAccountRequest.class.uniqueId57
│       │   │   │   │       ├── CreateCustomerRequest.class.uniqueId39
│       │   │   │   │       ├── CreateMovementRequest.class.uniqueId77
│       │   │   │   │       ├── Customer.class.uniqueId67
│       │   │   │   │       ├── CustomerFields.class.uniqueId10
│       │   │   │   │       ├── CustomerRepositoryAdapter.class.uniqueId20
│       │   │   │   │       ├── CustomerRepositoryPort.class.uniqueId31
│       │   │   │   │       ├── CustomerResponse.class.uniqueId43
│       │   │   │   │       ├── CustomersApi$1.class.uniqueId28
│       │   │   │   │       ├── CustomersApi$10.class.uniqueId81
│       │   │   │   │       ├── CustomersApi$11.class.uniqueId6
│       │   │   │   │       ├── CustomersApi$12.class.uniqueId29
│       │   │   │   │       ├── CustomersApi$13.class.uniqueId49
│       │   │   │   │       ├── CustomersApi$14.class.uniqueId32
│       │   │   │   │       ├── CustomersApi$15.class.uniqueId11
│       │   │   │   │       ├── CustomersApi$16.class.uniqueId83
│       │   │   │   │       ├── CustomersApi$17.class.uniqueId69
│       │   │   │   │       ├── CustomersApi$18.class.uniqueId5
│       │   │   │   │       ├── CustomersApi$19.class.uniqueId73
│       │   │   │   │       ├── CustomersApi$2.class.uniqueId50
│       │   │   │   │       ├── CustomersApi$20.class.uniqueId40
│       │   │   │   │       ├── CustomersApi$21.class.uniqueId7
│       │   │   │   │       ├── CustomersApi$22.class.uniqueId71
│       │   │   │   │       ├── CustomersApi$23.class.uniqueId48
│       │   │   │   │       ├── CustomersApi$24.class.uniqueId75
│       │   │   │   │       ├── CustomersApi$25.class.uniqueId8
│       │   │   │   │       ├── CustomersApi$3.class.uniqueId87
│       │   │   │   │       ├── CustomersApi$4.class.uniqueId24
│       │   │   │   │       ├── CustomersApi$5.class.uniqueId44
│       │   │   │   │       ├── CustomersApi$6.class.uniqueId78
│       │   │   │   │       ├── CustomersApi$7.class.uniqueId3
│       │   │   │   │       ├── CustomersApi$8.class.uniqueId26
│       │   │   │   │       ├── CustomersApi$9.class.uniqueId65
│       │   │   │   │       ├── CustomersApi.class.uniqueId2
│       │   │   │   │       ├── GlobalExceptionHandler.class.uniqueId66
│       │   │   │   │       ├── HttpBasicAuth.class.uniqueId86
│       │   │   │   │       ├── HttpBearerAuth.class.uniqueId41
│       │   │   │   │       ├── JavaTimeFormatter.class.uniqueId51
│       │   │   │   │       ├── MovementBase.class.uniqueId45
│       │   │   │   │       ├── MovementResponse.class.uniqueId12
│       │   │   │   │       ├── MovementRestMapper$1.class.uniqueId15
│       │   │   │   │       ├── MovementRestMapper.class.uniqueId35
│       │   │   │   │       ├── MovementRestMapperImpl.class.uniqueId76
│       │   │   │   │       ├── MovementRestMapperImpl.java.uniqueId52
│       │   │   │   │       ├── MovementsApi.class.uniqueId13
│       │   │   │   │       ├── MovementsController.class.uniqueId1
│       │   │   │   │       ├── MovementServiceImpl.class.uniqueId68
│       │   │   │   │       ├── MovementType.class.uniqueId23
│       │   │   │   │       ├── PagedAccountsResponse.class.uniqueId30
│       │   │   │   │       ├── PagedCustomersResponse.class.uniqueId21
│       │   │   │   │       ├── PagedMovementsResponse.class.uniqueId79
│       │   │   │   │       ├── PersonBase.class.uniqueId36
│       │   │   │   │       ├── ReportController.class.uniqueId63
│       │   │   │   │       ├── ReportRestMapper$1.class.uniqueId59
│       │   │   │   │       ├── ReportRestMapper.class.uniqueId54
│       │   │   │   │       ├── ReportRestMapperImpl.class.uniqueId16
│       │   │   │   │       ├── ReportRestMapperImpl.java.uniqueId82
│       │   │   │   │       ├── ReportsApi.class.uniqueId70
│       │   │   │   │       ├── ReportServiceImpl.class.uniqueId4
│       │   │   │   │       ├── RFC3339DateFormat.class.uniqueId37
│       │   │   │   │       ├── ServerConfiguration.class.uniqueId84
│       │   │   │   │       ├── ServerVariable.class.uniqueId72
│       │   │   │   │       ├── StringUtil.class.uniqueId18
│       │   │   │   │       ├── UpdateAccountRequest.class.uniqueId53
│       │   │   │   │       ├── UpdateCustomerRequest.class.uniqueId80
│       │   │   │   │       └── UpdateMovementRequest.class.uniqueId42
│       │   │   │   └── previous-compilation-data.bin
│       │   │   ├── compileTestJava
│       │   │   │   ├── compileTransaction
│       │   │   │   │   ├── backup-dir
│       │   │   │   │   └── stash-dir
│       │   │   │   │       ├── AccountRepositoryAdapterTest.class.uniqueId1
│       │   │   │   │       └── AccountsControllerTest.class.uniqueId0
│       │   │   │   └── previous-compilation-data.bin
│       │   │   ├── jacocoTestCoverageVerification
│       │   │   │   └── success.txt
│       │   │   ├── jar
│       │   │   │   └── MANIFEST.MF
│       │   │   └── test
│       │   └── resolvedMainClassName
│       ├── gradle
│       │   └── wrapper
│       │       ├── gradle-wrapper.jar
│       │       └── gradle-wrapper.properties
│       ├── src
│       │   ├── main
│       │   │   ├── java
│       │   │   │   └── com
│       │   │   │       └── challenge
│       │   │   │           └── accounts_movements_service
│       │   │   │               ├── application
│       │   │   │               │   ├── input
│       │   │   │               │   │   └── port
│       │   │   │               │   │       ├── AccountInputPort.java
│       │   │   │               │   │       ├── MovementInputPort.java
│       │   │   │               │   │       └── ReportInputPort.java
│       │   │   │               │   ├── output
│       │   │   │               │   │   └── port
│       │   │   │               │   │       ├── AccountRepositoryPort.java
│       │   │   │               │   │       ├── CustomerRepositoryPort.java
│       │   │   │               │   │       └── MovementRepositoryPort.java
│       │   │   │               │   ├── service
│       │   │   │               │   │   └── impl
│       │   │   │               │   │       ├── AccountServiceImpl.java
│       │   │   │               │   │       ├── MovementServiceImpl.java
│       │   │   │               │   │       └── ReportServiceImpl.java
│       │   │   │               │   └── util
│       │   │   │               │       ├── Constants.java
│       │   │   │               │       └── PagedResult.java
│       │   │   │               ├── domain
│       │   │   │               │   ├── exception
│       │   │   │               │   │   ├── AccountInactiveException.java
│       │   │   │               │   │   ├── AccountNotFoundException.java
│       │   │   │               │   │   ├── CustomerNotFoundException.java
│       │   │   │               │   │   ├── DomainException.java
│       │   │   │               │   │   ├── DomainValidationException.java
│       │   │   │               │   │   ├── DownstreamServiceException.java
│       │   │   │               │   │   ├── DuplicatedAccountNumberException.java
│       │   │   │               │   │   ├── InsufficientFundsException.java
│       │   │   │               │   │   └── MovementNotFoundException.java
│       │   │   │               │   ├── model
│       │   │   │               │   │   ├── Account.java
│       │   │   │               │   │   ├── AccountStatementReport.java
│       │   │   │               │   │   ├── AccountStatementReportAccount.java
│       │   │   │               │   │   ├── AccountStatementReportMovement.java
│       │   │   │               │   │   ├── AccountType.java
│       │   │   │               │   │   ├── Movement.java
│       │   │   │               │   │   └── MovementType.java
│       │   │   │               │   ├── policy
│       │   │   │               │   │   └── MovementPolicy.java
│       │   │   │               │   └── util
│       │   │   │               │       └── Constants.java
│       │   │   │               ├── infrastructure
│       │   │   │               │   ├── exception
│       │   │   │               │   │   └── GlobalExceptionHandler.java
│       │   │   │               │   ├── input
│       │   │   │               │   │   └── adapter
│       │   │   │               │   │       ├── controller
│       │   │   │               │   │       │   ├── AccountsController.java
│       │   │   │               │   │       │   ├── MovementsController.java
│       │   │   │               │   │       │   └── ReportController.java
│       │   │   │               │   │       └── mapper
│       │   │   │               │   │           ├── AccountRestMapper.java
│       │   │   │               │   │           ├── MovementRestMapper.java
│       │   │   │               │   │           └── ReportRestMapper.java
│       │   │   │               │   ├── output
│       │   │   │               │   │   ├── adapter
│       │   │   │               │   │   │   ├── entity
│       │   │   │               │   │   │   │   ├── AccountEntity.java
│       │   │   │               │   │   │   │   └── MovementEntity.java
│       │   │   │               │   │   │   ├── mapper
│       │   │   │               │   │   │   │   ├── AccountJpaMapper.java
│       │   │   │               │   │   │   │   └── MovementJpaMapper.java
│       │   │   │               │   │   │   ├── repository
│       │   │   │               │   │   │   │   ├── AccountJpaRepository.java
│       │   │   │               │   │   │   │   └── MovementJpaRepository.java
│       │   │   │               │   │   │   ├── AccountRepositoryAdapter.java
│       │   │   │               │   │   │   ├── CustomerRepositoryAdapter.java
│       │   │   │               │   │   │   └── MovementRepositoryAdapter.java
│       │   │   │               │   │   └── config
│       │   │   │               │   │       ├── ApiClientConfiguration.java
│       │   │   │               │   │       └── MovementPolicyConfiguration.java
│       │   │   │               │   └── util
│       │   │   │               │       └── Constants.java
│       │   │   │               └── AccountsMovementsServiceApplication.java
│       │   │   └── resources
│       │   │       ├── openapi-templates
│       │   │       │   ├── client
│       │   │       │   │   ├── api.mustache
│       │   │       │   │   └── ApiClient.mustache
│       │   │       │   └── bodyParams.mustache
│       │   │       ├── application.yaml
│       │   │       ├── customer_service.yaml
│       │   │       └── openapi.yaml
│       │   └── test
│       │       ├── java
│       │       │   └── com
│       │       │       └── challenge
│       │       │           └── accounts_movements_service
│       │       │               ├── application
│       │       │               │   └── service
│       │       │               │       └── impl
│       │       │               │           ├── AccountServiceImplTest.java
│       │       │               │           ├── MovementServiceImplTest.java
│       │       │               │           └── ReportServiceImplTest.java
│       │       │               ├── domain
│       │       │               │   ├── exception
│       │       │               │   │   ├── AccountInactiveExceptionTest.java
│       │       │               │   │   ├── AccountNotFoundExceptionTest.java
│       │       │               │   │   ├── CustomerNotFoundExceptionTest.java
│       │       │               │   │   ├── DomainExceptionTest.java
│       │       │               │   │   ├── DomainValidationExceptionTest.java
│       │       │               │   │   ├── DownstreamServiceExceptionTest.java
│       │       │               │   │   ├── DuplicatedAccountNumberExceptionTest.java
│       │       │               │   │   ├── InsufficientFundsExceptionTest.java
│       │       │               │   │   └── MovementNotFoundExceptionTest.java
│       │       │               │   ├── model
│       │       │               │   │   ├── AccountStatementReportAccountTest.java
│       │       │               │   │   ├── AccountStatementReportMovementTest.java
│       │       │               │   │   ├── AccountStatementReportTest.java
│       │       │               │   │   ├── AccountTest.java
│       │       │               │   │   ├── AccountTypeTest.java
│       │       │               │   │   ├── MovementTest.java
│       │       │               │   │   └── MovementTypeTest.java
│       │       │               │   └── policy
│       │       │               │       └── MovementPolicyTest.java
│       │       │               ├── infrastructure
│       │       │               │   ├── exception
│       │       │               │   │   └── GlobalExceptionHandlerTest.java
│       │       │               │   ├── input
│       │       │               │   │   └── adapter
│       │       │               │   │       └── controller
│       │       │               │   │           ├── AccountsControllerTest.java
│       │       │               │   │           ├── MovementsControllerTest.java
│       │       │               │   │           └── ReportControllerTest.java
│       │       │               │   └── output
│       │       │               │       └── adapter
│       │       │               │           ├── entity
│       │       │               │           │   ├── AccountEntityTest.java
│       │       │               │           │   └── MovementEntityTest.java
│       │       │               │           ├── mapper
│       │       │               │           │   ├── AccountJpaMapperTest.java
│       │       │               │           │   └── MovementJpaMapperTest.java
│       │       │               │           ├── AccountRepositoryAdapterTest.java
│       │       │               │           ├── CustomerRepositoryAdapterTest.java
│       │       │               │           └── MovementRepositoryAdapterTest.java
│       │       │               └── AccountsMovementsServiceApplicationTests.java
│       │       └── resources
│       │           ├── application-test.yaml
│       │           └── schema.sql
│       ├── .gitattributes
│       ├── .gitignore
│       ├── build.gradle
│       ├── gradlew
│       ├── gradlew.bat
│       ├── HELP.md
│       └── settings.gradle
├── customer-service
│   └── customer-service
│       ├── .github
│       │   └── java-upgrade
│       │       ├── hooks
│       │       │   └── scripts
│       │       │       ├── recordToolUse.ps1
│       │       │       └── recordToolUse.sh
│       │       └── .gitignore
│       ├── .gradle
│       │   ├── 8.14.4
│       │   │   ├── checksums
│       │   │   │   ├── checksums.lock
│       │   │   │   ├── md5-checksums.bin
│       │   │   │   └── sha1-checksums.bin
│       │   │   ├── executionHistory
│       │   │   │   ├── executionHistory.bin
│       │   │   │   └── executionHistory.lock
│       │   │   ├── expanded
│       │   │   │   └── expanded.lock
│       │   │   ├── fileChanges
│       │   │   │   └── last-build.bin
│       │   │   ├── fileHashes
│       │   │   │   ├── fileHashes.bin
│       │   │   │   ├── fileHashes.lock
│       │   │   │   └── resourceHashesCache.bin
│       │   │   ├── vcsMetadata
│       │   │   └── gc.properties
│       │   ├── buildOutputCleanup
│       │   │   ├── buildOutputCleanup.lock
│       │   │   ├── cache.properties
│       │   │   └── outputFiles.bin
│       │   ├── vcs-1
│       │   │   └── gc.properties
│       │   └── file-system.probe
│       ├── .idea
│       │   ├── modules
│       │   │   ├── customer-service.main.iml
│       │   │   └── customer-service.test.iml
│       │   ├── .gitignore
│       │   ├── compiler.xml
│       │   ├── copilot.data.migration.agent.xml
│       │   ├── gradle.xml
│       │   ├── misc.xml
│       │   ├── modules.xml
│       │   ├── vcs.xml
│       │   └── workspace.xml
│       ├── .vscode
│       │   └── settings.json
│       ├── build
│       │   ├── classes
│       │   │   └── java
│       │   │       ├── main
│       │   │       │   └── com
│       │   │       │       └── challenge
│       │   │       │           └── customer_service
│       │   │       │               ├── application
│       │   │       │               │   ├── input
│       │   │       │               │   │   └── port
│       │   │       │               │   │       └── CustomerInputPort.class
│       │   │       │               │   ├── output
│       │   │       │               │   │   └── port
│       │   │       │               │   │       ├── CustomerRepositoryPort.class
│       │   │       │               │   │       └── PasswordHasherPort.class
│       │   │       │               │   ├── service
│       │   │       │               │   │   └── impl
│       │   │       │               │   │       └── CustomerServiceImpl.class
│       │   │       │               │   └── util
│       │   │       │               │       ├── Constants.class
│       │   │       │               │       └── PagedResult.class
│       │   │       │               ├── domain
│       │   │       │               │   ├── exception
│       │   │       │               │   │   ├── CustomerNotFoundException.class
│       │   │       │               │   │   ├── DomainValidationException.class
│       │   │       │               │   │   └── DuplicatedIdentificationException.class
│       │   │       │               │   ├── model
│       │   │       │               │   │   ├── Customer$CustomerBuilder.class
│       │   │       │               │   │   ├── Customer.class
│       │   │       │               │   │   ├── Gender.class
│       │   │       │               │   │   ├── Person$PersonBuilder.class
│       │   │       │               │   │   └── Person.class
│       │   │       │               │   └── util
│       │   │       │               │       └── Constants.class
│       │   │       │               ├── infrastructure
│       │   │       │               │   ├── exception
│       │   │       │               │   │   └── GlobalExceptionHandler.class
│       │   │       │               │   ├── input
│       │   │       │               │   │   └── adapter
│       │   │       │               │   │       ├── controller
│       │   │       │               │   │       │   └── CustomersController.class
│       │   │       │               │   │       ├── mapper
│       │   │       │               │   │       │   ├── CustomerRestMapper$1.class
│       │   │       │               │   │       │   ├── CustomerRestMapper.class
│       │   │       │               │   │       │   └── CustomerRestMapperImpl.class
│       │   │       │               │   │       └── rest
│       │   │       │               │   │           └── customer_service
│       │   │       │               │   │               ├── bean
│       │   │       │               │   │               │   ├── ApiError.class
│       │   │       │               │   │               │   ├── ApiErrorDetailsInner.class
│       │   │       │               │   │               │   ├── CreateCustomerRequest.class
│       │   │       │               │   │               │   ├── Customer.class
│       │   │       │               │   │               │   ├── CustomerFields.class
│       │   │       │               │   │               │   ├── CustomerResponse.class
│       │   │       │               │   │               │   ├── Gender.class
│       │   │       │               │   │               │   ├── PagedCustomersResponse.class
│       │   │       │               │   │               │   ├── PersonBase.class
│       │   │       │               │   │               │   └── UpdateCustomerRequest.class
│       │   │       │               │   │               ├── ApiUtil.class
│       │   │       │               │   │               └── CustomersApi.class
│       │   │       │               │   ├── output
│       │   │       │               │   │   └── adapter
│       │   │       │               │   │       ├── entity
│       │   │       │               │   │       │   ├── CustomerEntity.class
│       │   │       │               │   │       │   └── PersonEntity.class
│       │   │       │               │   │       ├── mapper
│       │   │       │               │   │       │   └── CustomerJpaMapper.class
│       │   │       │               │   │       ├── repository
│       │   │       │               │   │       │   ├── CustomerJpaRepository.class
│       │   │       │               │   │       │   └── PersonJpaRepository.class
│       │   │       │               │   │       ├── security
│       │   │       │               │   │       │   └── BCryptPasswordHasherAdapter.class
│       │   │       │               │   │       └── CustomeRepositoryAdapter.class
│       │   │       │               │   └── utils
│       │   │       │               │       └── Constants.class
│       │   │       │               └── CustomerServiceApplication.class
│       │   │       └── test
│       │   │           └── com
│       │   │               └── challenge
│       │   │                   └── customer_service
│       │   │                       ├── application
│       │   │                       │   └── service
│       │   │                       │       └── impl
│       │   │                       │           └── CustomerServiceImplTest.class
│       │   │                       ├── domain
│       │   │                       │   ├── exception
│       │   │                       │   │   ├── CustomerNotFoundExceptionTest.class
│       │   │                       │   │   ├── DomainValidationExceptionTest.class
│       │   │                       │   │   └── DuplicatedIdentificationExceptionTest.class
│       │   │                       │   └── model
│       │   │                       │       ├── CustomerTest.class
│       │   │                       │       ├── GenderTest.class
│       │   │                       │       └── PersonTest.class
│       │   │                       ├── infrastructure
│       │   │                       │   ├── exception
│       │   │                       │   │   └── GlobalExceptionHandlerTest.class
│       │   │                       │   ├── input
│       │   │                       │   │   └── adapter
│       │   │                       │   │       └── controller
│       │   │                       │   │           └── CustomersControllerTest.class
│       │   │                       │   └── output
│       │   │                       │       └── adapter
│       │   │                       │           ├── entity
│       │   │                       │           │   ├── CustomerEntityTest.class
│       │   │                       │           │   └── PersonEntityTest.class
│       │   │                       │           ├── mapper
│       │   │                       │           │   └── CustomerJpaMapperTest.class
│       │   │                       │           ├── security
│       │   │                       │           │   └── BCryptPasswordHasherAdapterTest.class
│       │   │                       │           └── CustomerRepositoryAdapterTest.class
│       │   │                       ├── karate
│       │   │                       │   ├── KarateIT.class
│       │   │                       │   └── TestcontainersInitializer.class
│       │   │                       └── CustomerServiceApplicationTests.class
│       │   ├── generated
│       │   │   ├── .openapi-generator
│       │   │   │   ├── FILES
│       │   │   │   └── VERSION
│       │   │   ├── sources
│       │   │   │   ├── annotationProcessor
│       │   │   │   │   └── java
│       │   │   │   │       ├── main
│       │   │   │   │       │   └── com
│       │   │   │   │       │       └── challenge
│       │   │   │   │       │           └── customer_service
│       │   │   │   │       │               └── infrastructure
│       │   │   │   │       │                   └── input
│       │   │   │   │       │                       └── adapter
│       │   │   │   │       │                           └── mapper
│       │   │   │   │       │                               └── CustomerRestMapperImpl.java
│       │   │   │   │       └── test
│       │   │   │   └── headers
│       │   │   │       └── java
│       │   │   │           ├── main
│       │   │   │           └── test
│       │   │   ├── src
│       │   │   │   └── main
│       │   │   │       └── java
│       │   │   │           └── com
│       │   │   │               └── challenge
│       │   │   │                   └── customer_service
│       │   │   │                       └── infrastructure
│       │   │   │                           └── input
│       │   │   │                               └── adapter
│       │   │   │                                   └── rest
│       │   │   │                                       └── customer_service
│       │   │   │                                           ├── bean
│       │   │   │                                           │   ├── ApiError.java
│       │   │   │                                           │   ├── ApiErrorDetailsInner.java
│       │   │   │                                           │   ├── CreateCustomerRequest.java
│       │   │   │                                           │   ├── Customer.java
│       │   │   │                                           │   ├── CustomerFields.java
│       │   │   │                                           │   ├── CustomerResponse.java
│       │   │   │                                           │   ├── Gender.java
│       │   │   │                                           │   ├── PagedCustomersResponse.java
│       │   │   │                                           │   ├── PersonBase.java
│       │   │   │                                           │   └── UpdateCustomerRequest.java
│       │   │   │                                           ├── ApiUtil.java
│       │   │   │                                           └── CustomersApi.java
│       │   │   ├── .openapi-generator-ignore
│       │   │   ├── pom.xml
│       │   │   └── README.md
│       │   ├── jacoco
│       │   │   └── test.exec
│       │   ├── karate-reports
│       │   │   ├── res
│       │   │   │   ├── bootstrap.min.css
│       │   │   │   ├── bootstrap.min.js
│       │   │   │   ├── jquery-ui.min.js
│       │   │   │   ├── jquery.min.js
│       │   │   │   ├── jquery.tablesorter.min.js
│       │   │   │   ├── karate-report.css
│       │   │   │   ├── karate-report.js
│       │   │   │   ├── Resemble.js
│       │   │   │   ├── vis.min.css
│       │   │   │   └── vis.min.js
│       │   │   ├── com.challenge.customer_service.karate.customers.html
│       │   │   ├── com.challenge.customer_service.karate.customers.karate-json.txt
│       │   │   ├── favicon.ico
│       │   │   ├── karate-labs-logo-ring.svg
│       │   │   ├── karate-logo.png
│       │   │   ├── karate-logo.svg
│       │   │   ├── karate-summary-json.txt
│       │   │   ├── karate-summary.html
│       │   │   ├── karate-tags.html
│       │   │   └── karate-timeline.html
│       │   ├── libs
│       │   │   ├── customer-service-0.0.1-SNAPSHOT-plain.jar
│       │   │   └── customer-service-0.0.1-SNAPSHOT.jar
│       │   ├── reports
│       │   │   ├── jacoco
│       │   │   │   └── test
│       │   │   │       ├── html
│       │   │   │       │   ├── com.challenge.customer_service
│       │   │   │       │   │   ├── CustomerServiceApplication.html
│       │   │   │       │   │   ├── CustomerServiceApplication.java.html
│       │   │   │       │   │   ├── index.html
│       │   │   │       │   │   └── index.source.html
│       │   │   │       │   ├── com.challenge.customer_service.application.service.impl
│       │   │   │       │   │   ├── CustomerServiceImpl.html
│       │   │   │       │   │   ├── CustomerServiceImpl.java.html
│       │   │   │       │   │   ├── index.html
│       │   │   │       │   │   └── index.source.html
│       │   │   │       │   ├── com.challenge.customer_service.application.util
│       │   │   │       │   │   ├── index.html
│       │   │   │       │   │   ├── index.source.html
│       │   │   │       │   │   ├── PagedResult.html
│       │   │   │       │   │   └── PagedResult.java.html
│       │   │   │       │   ├── com.challenge.customer_service.domain.exception
│       │   │   │       │   │   ├── CustomerNotFoundException.html
│       │   │   │       │   │   ├── CustomerNotFoundException.java.html
│       │   │   │       │   │   ├── DomainValidationException.html
│       │   │   │       │   │   ├── DomainValidationException.java.html
│       │   │   │       │   │   ├── DuplicatedIdentificationException.html
│       │   │   │       │   │   ├── DuplicatedIdentificationException.java.html
│       │   │   │       │   │   ├── index.html
│       │   │   │       │   │   └── index.source.html
│       │   │   │       │   ├── com.challenge.customer_service.domain.model
│       │   │   │       │   │   ├── Gender.html
│       │   │   │       │   │   ├── Gender.java.html
│       │   │   │       │   │   ├── index.html
│       │   │   │       │   │   └── index.source.html
│       │   │   │       │   ├── com.challenge.customer_service.infrastructure.exception
│       │   │   │       │   │   ├── GlobalExceptionHandler.html
│       │   │   │       │   │   ├── GlobalExceptionHandler.java.html
│       │   │   │       │   │   ├── index.html
│       │   │   │       │   │   └── index.source.html
│       │   │   │       │   ├── com.challenge.customer_service.infrastructure.input.adapter.controller
│       │   │   │       │   │   ├── CustomersController.html
│       │   │   │       │   │   ├── CustomersController.java.html
│       │   │   │       │   │   ├── index.html
│       │   │   │       │   │   └── index.source.html
│       │   │   │       │   ├── com.challenge.customer_service.infrastructure.input.adapter.mapper
│       │   │   │       │   │   ├── CustomerRestMapper.html
│       │   │   │       │   │   ├── CustomerRestMapper.java.html
│       │   │   │       │   │   ├── CustomerRestMapperImpl.html
│       │   │   │       │   │   ├── index.html
│       │   │   │       │   │   └── index.source.html
│       │   │   │       │   ├── com.challenge.customer_service.infrastructure.input.adapter.rest.customer_service
│       │   │   │       │   │   ├── ApiUtil.html
│       │   │   │       │   │   ├── ApiUtil.java.html
│       │   │   │       │   │   ├── index.html
│       │   │   │       │   │   └── index.source.html
│       │   │   │       │   ├── com.challenge.customer_service.infrastructure.input.adapter.rest.customer_service.bean
│       │   │   │       │   │   ├── ApiError.html
│       │   │   │       │   │   ├── ApiError.java.html
│       │   │   │       │   │   ├── ApiErrorDetailsInner.html
│       │   │   │       │   │   ├── ApiErrorDetailsInner.java.html
│       │   │   │       │   │   ├── CreateCustomerRequest.html
│       │   │   │       │   │   ├── CreateCustomerRequest.java.html
│       │   │   │       │   │   ├── Customer.html
│       │   │   │       │   │   ├── Customer.java.html
│       │   │   │       │   │   ├── CustomerFields.html
│       │   │   │       │   │   ├── CustomerFields.java.html
│       │   │   │       │   │   ├── CustomerResponse.html
│       │   │   │       │   │   ├── CustomerResponse.java.html
│       │   │   │       │   │   ├── Gender.html
│       │   │   │       │   │   ├── Gender.java.html
│       │   │   │       │   │   ├── index.html
│       │   │   │       │   │   ├── index.source.html
│       │   │   │       │   │   ├── PagedCustomersResponse.html
│       │   │   │       │   │   ├── PagedCustomersResponse.java.html
│       │   │   │       │   │   ├── PersonBase.html
│       │   │   │       │   │   ├── PersonBase.java.html
│       │   │   │       │   │   ├── UpdateCustomerRequest.html
│       │   │   │       │   │   └── UpdateCustomerRequest.java.html
│       │   │   │       │   ├── com.challenge.customer_service.infrastructure.output.adapter
│       │   │   │       │   │   ├── CustomeRepositoryAdapter.html
│       │   │   │       │   │   ├── CustomeRepositoryAdapter.java.html
│       │   │   │       │   │   ├── index.html
│       │   │   │       │   │   └── index.source.html
│       │   │   │       │   ├── com.challenge.customer_service.infrastructure.output.adapter.mapper
│       │   │   │       │   │   ├── CustomerJpaMapper.html
│       │   │   │       │   │   ├── CustomerJpaMapper.java.html
│       │   │   │       │   │   ├── index.html
│       │   │   │       │   │   └── index.source.html
│       │   │   │       │   ├── com.challenge.customer_service.infrastructure.output.adapter.security
│       │   │   │       │   │   ├── BCryptPasswordHasherAdapter.html
│       │   │   │       │   │   ├── BCryptPasswordHasherAdapter.java.html
│       │   │   │       │   │   ├── index.html
│       │   │   │       │   │   └── index.source.html
│       │   │   │       │   ├── jacoco-resources
│       │   │   │       │   │   ├── branchfc.gif
│       │   │   │       │   │   ├── branchnc.gif
│       │   │   │       │   │   ├── branchpc.gif
│       │   │   │       │   │   ├── bundle.gif
│       │   │   │       │   │   ├── class.gif
│       │   │   │       │   │   ├── down.gif
│       │   │   │       │   │   ├── greenbar.gif
│       │   │   │       │   │   ├── group.gif
│       │   │   │       │   │   ├── method.gif
│       │   │   │       │   │   ├── package.gif
│       │   │   │       │   │   ├── prettify.css
│       │   │   │       │   │   ├── prettify.js
│       │   │   │       │   │   ├── redbar.gif
│       │   │   │       │   │   ├── report.css
│       │   │   │       │   │   ├── report.gif
│       │   │   │       │   │   ├── session.gif
│       │   │   │       │   │   ├── sort.gif
│       │   │   │       │   │   ├── sort.js
│       │   │   │       │   │   ├── source.gif
│       │   │   │       │   │   └── up.gif
│       │   │   │       │   ├── index.html
│       │   │   │       │   └── jacoco-sessions.html
│       │   │   │       ├── jacocoTestReport.csv
│       │   │   │       └── jacocoTestReport.xml
│       │   │   ├── problems
│       │   │   │   └── problems-report.html
│       │   │   └── tests
│       │   │       └── test
│       │   │           ├── classes
│       │   │           │   ├── com.challenge.customer_service.application.service.impl.CustomerServiceImplTest.html
│       │   │           │   ├── com.challenge.customer_service.CustomerServiceApplicationTests.html
│       │   │           │   ├── com.challenge.customer_service.domain.exception.CustomerNotFoundExceptionTest.html
│       │   │           │   ├── com.challenge.customer_service.domain.exception.DomainValidationExceptionTest.html
│       │   │           │   ├── com.challenge.customer_service.domain.exception.DuplicatedIdentificationExceptionTest.html
│       │   │           │   ├── com.challenge.customer_service.domain.model.CustomerTest.html
│       │   │           │   ├── com.challenge.customer_service.domain.model.GenderTest.html
│       │   │           │   ├── com.challenge.customer_service.domain.model.PersonTest.html
│       │   │           │   ├── com.challenge.customer_service.infrastructure.exception.GlobalExceptionHandlerTest.html
│       │   │           │   ├── com.challenge.customer_service.infrastructure.input.adapter.controller.CustomersControllerTest.html
│       │   │           │   ├── com.challenge.customer_service.infrastructure.output.adapter.CustomerRepositoryAdapterTest.html
│       │   │           │   ├── com.challenge.customer_service.infrastructure.output.adapter.entity.CustomerEntityTest.html
│       │   │           │   ├── com.challenge.customer_service.infrastructure.output.adapter.entity.PersonEntityTest.html
│       │   │           │   ├── com.challenge.customer_service.infrastructure.output.adapter.mapper.CustomerJpaMapperTest.html
│       │   │           │   ├── com.challenge.customer_service.infrastructure.output.adapter.security.BCryptPasswordHasherAdapterTest.html
│       │   │           │   └── com.challenge.customer_service.karate.KarateIT.html
│       │   │           ├── css
│       │   │           │   ├── base-style.css
│       │   │           │   └── style.css
│       │   │           ├── js
│       │   │           │   └── report.js
│       │   │           ├── packages
│       │   │           │   ├── com.challenge.customer_service.application.service.impl.html
│       │   │           │   ├── com.challenge.customer_service.domain.exception.html
│       │   │           │   ├── com.challenge.customer_service.domain.model.html
│       │   │           │   ├── com.challenge.customer_service.html
│       │   │           │   ├── com.challenge.customer_service.infrastructure.exception.html
│       │   │           │   ├── com.challenge.customer_service.infrastructure.input.adapter.controller.html
│       │   │           │   ├── com.challenge.customer_service.infrastructure.output.adapter.entity.html
│       │   │           │   ├── com.challenge.customer_service.infrastructure.output.adapter.html
│       │   │           │   ├── com.challenge.customer_service.infrastructure.output.adapter.mapper.html
│       │   │           │   ├── com.challenge.customer_service.infrastructure.output.adapter.security.html
│       │   │           │   └── com.challenge.customer_service.karate.html
│       │   │           └── index.html
│       │   ├── resources
│       │   │   ├── main
│       │   │   │   ├── META-INF
│       │   │   │   │   └── build-info.properties
│       │   │   │   ├── openapi-templates
│       │   │   │   │   ├── client
│       │   │   │   │   │   ├── api.mustache
│       │   │   │   │   │   └── ApiClient.mustache
│       │   │   │   │   └── bodyParams.mustache
│       │   │   │   ├── application.yaml
│       │   │   │   └── openapi.yaml
│       │   │   └── test
│       │   │       ├── com
│       │   │       │   └── challenge
│       │   │       │       └── customer_service
│       │   │       │           └── karate
│       │   │       │               └── customers.feature
│       │   │       ├── application-test.yaml
│       │   │       ├── BaseDatos.sql
│       │   │       ├── karate-config.js
│       │   │       └── schema.sql
│       │   ├── test-results
│       │   │   └── test
│       │   │       ├── binary
│       │   │       │   ├── output.bin
│       │   │       │   ├── output.bin.idx
│       │   │       │   └── results.bin
│       │   │       ├── TEST-com.challenge.customer_service.application.service.impl.CustomerServiceImplTest.xml
│       │   │       ├── TEST-com.challenge.customer_service.CustomerServiceApplicationTests.xml
│       │   │       ├── TEST-com.challenge.customer_service.domain.exception.CustomerNotFoundExceptionTest.xml
│       │   │       ├── TEST-com.challenge.customer_service.domain.exception.DomainValidationExceptionTest.xml
│       │   │       ├── TEST-com.challenge.customer_service.domain.exception.DuplicatedIdentificationExceptionTest.xml
│       │   │       ├── TEST-com.challenge.customer_service.domain.model.CustomerTest.xml
│       │   │       ├── TEST-com.challenge.customer_service.domain.model.GenderTest.xml
│       │   │       ├── TEST-com.challenge.customer_service.domain.model.PersonTest.xml
│       │   │       ├── TEST-com.challenge.customer_service.infrastructure.exception.GlobalExceptionHandlerTest.xml
│       │   │       ├── TEST-com.challenge.customer_service.infrastructure.input.adapter.controller.CustomersControllerTest.xml
│       │   │       ├── TEST-com.challenge.customer_service.infrastructure.output.adapter.CustomerRepositoryAdapterTest.xml
│       │   │       ├── TEST-com.challenge.customer_service.infrastructure.output.adapter.entity.CustomerEntityTest.xml
│       │   │       ├── TEST-com.challenge.customer_service.infrastructure.output.adapter.entity.PersonEntityTest.xml
│       │   │       ├── TEST-com.challenge.customer_service.infrastructure.output.adapter.mapper.CustomerJpaMapperTest.xml
│       │   │       ├── TEST-com.challenge.customer_service.infrastructure.output.adapter.security.BCryptPasswordHasherAdapterTest.xml
│       │   │       └── TEST-com.challenge.customer_service.karate.KarateIT.xml
│       │   ├── tmp
│       │   │   ├── .cache
│       │   │   │   └── expanded
│       │   │   │       └── zip_9892ccb804f78c0637616b68610d363f
│       │   │   │           ├── META-INF
│       │   │   │           │   ├── maven
│       │   │   │           │   │   └── org.jacoco
│       │   │   │           │   │       └── org.jacoco.agent
│       │   │   │           │   │           ├── pom.properties
│       │   │   │           │   │           └── pom.xml
│       │   │   │           │   └── MANIFEST.MF
│       │   │   │           ├── org
│       │   │   │           │   └── jacoco
│       │   │   │           │       └── agent
│       │   │   │           │           ├── AgentJar.class
│       │   │   │           │           └── package-info.class
│       │   │   │           ├── about.html
│       │   │   │           └── jacocoagent.jar
│       │   │   ├── bootJar
│       │   │   │   └── MANIFEST.MF
│       │   │   ├── compileJava
│       │   │   │   └── previous-compilation-data.bin
│       │   │   ├── compileTestJava
│       │   │   │   ├── compileTransaction
│       │   │   │   │   ├── backup-dir
│       │   │   │   │   └── stash-dir
│       │   │   │   │       └── CustomersControllerTest.class.uniqueId0
│       │   │   │   └── previous-compilation-data.bin
│       │   │   ├── jacocoTestCoverageVerification
│       │   │   │   └── success.txt
│       │   │   ├── jar
│       │   │   │   └── MANIFEST.MF
│       │   │   └── test
│       │   └── resolvedMainClassName
│       ├── gradle
│       │   └── wrapper
│       │       ├── gradle-wrapper.jar
│       │       └── gradle-wrapper.properties
│       ├── src
│       │   ├── main
│       │   │   ├── java
│       │   │   │   └── com
│       │   │   │       └── challenge
│       │   │   │           └── customer_service
│       │   │   │               ├── application
│       │   │   │               │   ├── input
│       │   │   │               │   │   └── port
│       │   │   │               │   │       └── CustomerInputPort.java
│       │   │   │               │   ├── output
│       │   │   │               │   │   └── port
│       │   │   │               │   │       ├── CustomerRepositoryPort.java
│       │   │   │               │   │       └── PasswordHasherPort.java
│       │   │   │               │   ├── service
│       │   │   │               │   │   └── impl
│       │   │   │               │   │       └── CustomerServiceImpl.java
│       │   │   │               │   └── util
│       │   │   │               │       ├── Constants.java
│       │   │   │               │       └── PagedResult.java
│       │   │   │               ├── domain
│       │   │   │               │   ├── exception
│       │   │   │               │   │   ├── CustomerNotFoundException.java
│       │   │   │               │   │   ├── DomainValidationException.java
│       │   │   │               │   │   └── DuplicatedIdentificationException.java
│       │   │   │               │   ├── model
│       │   │   │               │   │   ├── Customer.java
│       │   │   │               │   │   ├── Gender.java
│       │   │   │               │   │   └── Person.java
│       │   │   │               │   └── util
│       │   │   │               │       └── Constants.java
│       │   │   │               ├── infrastructure
│       │   │   │               │   ├── exception
│       │   │   │               │   │   └── GlobalExceptionHandler.java
│       │   │   │               │   ├── input
│       │   │   │               │   │   └── adapter
│       │   │   │               │   │       ├── controller
│       │   │   │               │   │       │   └── CustomersController.java
│       │   │   │               │   │       └── mapper
│       │   │   │               │   │           └── CustomerRestMapper.java
│       │   │   │               │   ├── output
│       │   │   │               │   │   └── adapter
│       │   │   │               │   │       ├── entity
│       │   │   │               │   │       │   ├── CustomerEntity.java
│       │   │   │               │   │       │   └── PersonEntity.java
│       │   │   │               │   │       ├── mapper
│       │   │   │               │   │       │   └── CustomerJpaMapper.java
│       │   │   │               │   │       ├── repository
│       │   │   │               │   │       │   ├── CustomerJpaRepository.java
│       │   │   │               │   │       │   └── PersonJpaRepository.java
│       │   │   │               │   │       ├── security
│       │   │   │               │   │       │   └── BCryptPasswordHasherAdapter.java
│       │   │   │               │   │       └── CustomeRepositoryAdapter.java
│       │   │   │               │   └── utils
│       │   │   │               │       └── Constants.java
│       │   │   │               └── CustomerServiceApplication.java
│       │   │   └── resources
│       │   │       ├── openapi-templates
│       │   │       │   ├── client
│       │   │       │   │   ├── api.mustache
│       │   │       │   │   └── ApiClient.mustache
│       │   │       │   └── bodyParams.mustache
│       │   │       ├── application.yaml
│       │   │       └── openapi.yaml
│       │   └── test
│       │       ├── java
│       │       │   └── com
│       │       │       └── challenge
│       │       │           └── customer_service
│       │       │               ├── application
│       │       │               │   └── service
│       │       │               │       └── impl
│       │       │               │           └── CustomerServiceImplTest.java
│       │       │               ├── domain
│       │       │               │   ├── exception
│       │       │               │   │   ├── CustomerNotFoundExceptionTest.java
│       │       │               │   │   ├── DomainValidationExceptionTest.java
│       │       │               │   │   └── DuplicatedIdentificationExceptionTest.java
│       │       │               │   └── model
│       │       │               │       ├── CustomerTest.java
│       │       │               │       ├── GenderTest.java
│       │       │               │       └── PersonTest.java
│       │       │               ├── infrastructure
│       │       │               │   ├── exception
│       │       │               │   │   └── GlobalExceptionHandlerTest.java
│       │       │               │   ├── input
│       │       │               │   │   └── adapter
│       │       │               │   │       └── controller
│       │       │               │   │           └── CustomersControllerTest.java
│       │       │               │   └── output
│       │       │               │       └── adapter
│       │       │               │           ├── entity
│       │       │               │           │   ├── CustomerEntityTest.java
│       │       │               │           │   └── PersonEntityTest.java
│       │       │               │           ├── mapper
│       │       │               │           │   └── CustomerJpaMapperTest.java
│       │       │               │           ├── security
│       │       │               │           │   └── BCryptPasswordHasherAdapterTest.java
│       │       │               │           └── CustomerRepositoryAdapterTest.java
│       │       │               ├── karate
│       │       │               │   ├── KarateIT.java
│       │       │               │   └── TestcontainersInitializer.java
│       │       │               └── CustomerServiceApplicationTests.java
│       │       └── resources
│       │           ├── com
│       │           │   └── challenge
│       │           │       └── customer_service
│       │           │           └── karate
│       │           │               └── customers.feature
│       │           ├── application-test.yaml
│       │           ├── BaseDatos.sql
│       │           ├── karate-config.js
│       │           └── schema.sql
│       ├── .gitattributes
│       ├── .gitignore
│       ├── build.gradle
│       ├── gradlew
│       ├── gradlew.bat
│       ├── HELP.md
│       └── settings.gradle
├── .gitignore
├── Accounts-Movements-Service-API-Contract-Tests.json
├── accounts-movements-service.md
├── BaseDatos.sql
├── Customer-Service-API-Contract-Tests.json
├── customer-service.md
├── docker-compose.yml
├── Ejercicio Técnico Backend Java v2 13.pdf
├── estructura.md
├── oasis.oaw
├── path_tracker.py
└── toDoAgent.md
```text
